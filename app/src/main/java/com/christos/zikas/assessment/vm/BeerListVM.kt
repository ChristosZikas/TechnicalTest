package com.christos.zikas.assessment.vm

import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BeerListVM : ViewModel()

class BeerListVMImpl @Inject constructor() : BeerListVM()