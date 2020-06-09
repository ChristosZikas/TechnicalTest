package com.christos.zikas.assessment.utils.dagger.components

import com.christos.zikas.assessment.models.CoroutineDelayModel
import com.christos.zikas.assessment.models.CoroutineDelayModelImpl
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapperImpl
import dagger.Module
import dagger.Provides

@Module
class ModelModules {
    @Provides
    fun providesBeerApiWrapper(): BeerApiWrapper = BeerApiWrapperImpl()

    @Provides
    fun providesCoroutineDelayModel(): CoroutineDelayModel = CoroutineDelayModelImpl()

}
