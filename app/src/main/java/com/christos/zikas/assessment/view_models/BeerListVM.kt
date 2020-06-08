package com.christos.zikas.assessment.view_models

import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.BeerListModelImpl
import javax.inject.Inject

abstract class BeerListVM : ViewModel()

class BeerListVMImpl @Inject constructor(private val beerListModel: BeerListModelImpl) :
    BeerListVM() {

}