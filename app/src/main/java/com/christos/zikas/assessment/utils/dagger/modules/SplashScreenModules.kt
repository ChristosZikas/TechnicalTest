package com.christos.zikas.assessment.utils.dagger.modules

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.christos.zikas.assessment.ui.SplashScreenFragment
import com.christos.zikas.assessment.utils.dagger.view_models.getVM
import com.christos.zikas.assessment.vm.SplashScreenVM
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        SplashScreenModules.Binders::class,
        SplashScreenModules.Providers::class
    ]
)
class SplashScreenModules {

    @Module
    abstract class Binders {
        @Binds
        abstract fun bindFragment(fragment: SplashScreenFragment): Fragment
    }

    @Module
    class Providers {

        @Provides
        fun providesSplashScreenVM(
            viewModelFactory: ViewModelProvider.Factory,
            fragment: SplashScreenFragment
        ) = viewModelFactory.getVM<SplashScreenVM>(fragment)
    }

}
