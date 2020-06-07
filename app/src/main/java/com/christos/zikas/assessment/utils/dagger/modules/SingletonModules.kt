package com.christos.zikas.assessment.utils.dagger.modules

import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import com.christos.zikas.assessment.utils.eventbus.EventBusHandlerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SingletonModules {
    @Provides
    @Singleton
    fun providesEventBus(): EventBusHandler = EventBusHandlerImpl()
}
