package learningtest.dagger2.feature.main

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainActivityModule {

    @Provides
    @Named("activityViewModel")
    fun provideViewModel(activity: MainActivity): MainViewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)

    /**
     * MainFragmentBuilder 에서 참조되는 프래그먼트와 충돌을 피하기 위해 @Named 사용.
     */
    @Provides
    @Named("mainFragmentInstance")
    fun provideMainFragment(): MainFragment = MainFragment.newInstance()

    @Provides
    fun provideMainRepository(): MainRepository = MainRepository()

    /**
     * 실제로 실행되지는 않아서 불필요한 객체 생성 하지는 않음. 뷰모델에 주입해야 하는 객체가 있는 경우 사용.
     */
    @Provides
    fun provideViewModel2(mainRepository: MainRepository): MainViewModel2 = MainViewModel2(mainRepository)
}

@Module
class MainFragmentModule {

    @Provides
    @Named("fragmentViewModel")
    fun provideFragmentViewModel(fragment: MainFragment): MainViewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)

}