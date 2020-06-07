package com.christos.zikas.assessment.ui

import android.os.Bundle
import android.view.View
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import com.christos.zikas.assessment.view_models.SplashScreenVM
import javax.inject.Inject

@SetContentView(layout = R.layout.activity_main)
class SplashScreenFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: SplashScreenVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}