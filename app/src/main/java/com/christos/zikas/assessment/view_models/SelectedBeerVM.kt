package com.christos.zikas.assessment.view_models

import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.SelectedBeerModelImpl
import javax.inject.Inject

abstract class SelectedBeerVM : ViewModel()


class SelectedBeerVMImpl
@Inject constructor(private val selectedBeerModel: SelectedBeerModelImpl) : SelectedBeerVM() {

}