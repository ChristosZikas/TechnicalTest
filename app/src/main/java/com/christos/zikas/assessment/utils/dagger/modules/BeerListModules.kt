package com.christos.zikas.assessment.utils.dagger.modules

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.christos.zikas.assessment.ui.BeerListFragment
import com.christos.zikas.assessment.utils.dagger.view_models.getVM
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import com.christos.zikas.assessment.view_models.BeerListVM
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes =
    [
        BeerListModules.Binders::class,
        BeerListModules.Providers::class
    ]
)
class BeerListModules {

    @Module
    abstract class Binders {
        @Binds
        abstract fun bindFragment(fragment: BeerListFragment): Fragment
    }

    @Module
    class Providers {
        @Provides
        fun providesSplashScreenVM(
            viewModelFactory: ViewModelProvider.Factory,
            fragment: BeerListFragment
        ) = viewModelFactory.getVM<BeerListVM>(fragment)
    }


}
