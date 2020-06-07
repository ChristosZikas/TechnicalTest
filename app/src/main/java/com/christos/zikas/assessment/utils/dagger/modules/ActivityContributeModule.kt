package com.christos.zikas.assessment.utils.dagger.modules

import com.christos.zikas.assessment.ui.TechTestActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributeModule {

    @ContributesAndroidInjector(modules = [TechTestModules::class])
    abstract fun contributeSplashActivity(): TechTestActivity

}