package com.christos.zikas.assessment.utils.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.christos.zikas.assessment.utils.dagger.view_models.ViewModelFactory
import com.christos.zikas.assessment.utils.dagger.view_models.ViewModelKey
import com.christos.zikas.assessment.view_models.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenVM::class)
    abstract fun bindsSplashScreenVM(viewModel: SplashScreenVMImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BeerListVM::class)
    abstract fun bindsBeerListVM(viewModel: BeerListVMImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectedBeerVM::class)
    abstract fun bindsSleectedBeerVM(viewModel: SelectedBeerVMImpl): ViewModel

}