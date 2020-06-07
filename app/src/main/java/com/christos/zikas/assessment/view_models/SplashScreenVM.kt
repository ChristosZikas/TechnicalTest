package com.christos.zikas.assessment.view_models

import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.BeerListModel
import com.christos.zikas.assessment.models.SplashScreenModel
import javax.inject.Inject

abstract class SplashScreenVM : ViewModel()

class SplashScreenVMImpl @Inject constructor(private val splashScreenModel: SplashScreenModel) : SplashScreenVM()
