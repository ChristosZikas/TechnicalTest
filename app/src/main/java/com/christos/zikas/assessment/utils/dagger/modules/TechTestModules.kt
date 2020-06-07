package com.christos.zikas.assessment.utils.dagger.modules

import com.christos.zikas.assessment.ui.BeerListFragment
import com.christos.zikas.assessment.ui.SelectedBeerFragment
import com.christos.zikas.assessment.ui.SplashScreenFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class TechTestModules {

    @ContributesAndroidInjector(modules = [SplashScreenModules::class])
    abstract fun providesSplashScreenFragment(): SplashScreenFragment

    @ContributesAndroidInjector(modules = [BeerListModules::class])
    abstract fun providesBeerListFragment(): BeerListFragment

    @ContributesAndroidInjector(modules = [SelectedBeerModules::class])
    abstract fun providesSelectedBeerFragment(): SelectedBeerFragment


}
