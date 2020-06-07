package com.christos.zikas.assessment.utils.dagger.modules

import com.christos.zikas.assessment.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributeModule {

    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): SplashActivity

}