package com.christos.zikas.assessment.view_models

import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.SplashScreenModelImpl
import javax.inject.Inject

abstract class SplashScreenVM : ViewModel() {
    abstract fun startCount()
}

class SplashScreenVMImpl @Inject constructor(private val splashScreenModel: SplashScreenModelImpl) : SplashScreenVM() {
    override fun startCount() {
        splashScreenModel.startCount()
    }
}
