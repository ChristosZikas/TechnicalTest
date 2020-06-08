package com.christos.zikas.assessment.utils.dagger.components

import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import dagger.Module
import dagger.Provides

@Module
class ModelModules {
    @Provides
    fun providesBeerApiWrapper() = BeerApiWrapper()

}
