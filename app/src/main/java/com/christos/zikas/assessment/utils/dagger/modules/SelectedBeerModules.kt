package com.christos.zikas.assessment.utils.dagger.modules

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.christos.zikas.assessment.models.SelectedBeerModel
import com.christos.zikas.assessment.models.SelectedBeerModelImpl
import com.christos.zikas.assessment.ui.SelectedBeerFragment
import com.christos.zikas.assessment.utils.dagger.view_models.getVM
import com.christos.zikas.assessment.view_models.SelectedBeerVM
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        SelectedBeerModules.Binders::class,
        SelectedBeerModules.Providers::class
    ]
)
class SelectedBeerModules {

    @Module
    abstract class Binders {
        @Binds
        abstract fun bindFragment(fragment: SelectedBeerFragment): Fragment
    }

    @Module
    class Providers {
        @Provides
        fun providesSelectedBeerModel(): SelectedBeerModel = SelectedBeerModelImpl()

        @Provides
        fun providesSplashScreenVM(
            viewModelFactory: ViewModelProvider.Factory,
            fragment: SelectedBeerFragment
        ) = viewModelFactory.getVM<SelectedBeerVM>(fragment)
    }

}
