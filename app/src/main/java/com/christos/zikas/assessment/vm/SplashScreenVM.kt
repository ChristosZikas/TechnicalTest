package com.christos.zikas.assessment.vm

import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class SplashScreenVM : ViewModel()

class SplashScreenVMImpl @Inject constructor() : SplashScreenVM()
