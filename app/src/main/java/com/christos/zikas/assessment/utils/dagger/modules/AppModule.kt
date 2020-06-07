package com.christos.zikas.assessment.utils.dagger.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        AppModule.Binders::class
    ]
)
abstract class AppModule {

    @Module
    abstract class Binders {

        @Binds
        abstract fun bindContext(application: Application): Context
    }
}