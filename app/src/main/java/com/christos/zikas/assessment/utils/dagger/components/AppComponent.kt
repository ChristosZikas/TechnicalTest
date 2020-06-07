package com.christos.zikas.assessment.utils.dagger.components

import android.app.Application
import com.christos.zikas.assessment.utils.dagger.TechApplication
import com.christos.zikas.assessment.utils.dagger.modules.ActivityContributeModule
import com.christos.zikas.assessment.utils.dagger.modules.AppModule
import com.christos.zikas.assessment.utils.dagger.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityContributeModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<TechApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}