package com.christos.zikas.assessment.vm

import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class SelectedBeerVM : ViewModel()

class SelectedBeerVMImpl @Inject constructor() : SelectedBeerVM()