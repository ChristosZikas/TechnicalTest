package com.christos.zikas.assessment.ui

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import com.christos.zikas.assessment.view_models.SplashScreenVM
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import javax.inject.Inject

@SetContentView(layout = R.layout.fragment_splash_screen)
class SplashScreenFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModel: SplashScreenVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loading_tv.startAnimation(AnimationUtils.loadAnimation(context, R.anim.repeat_fading))

    }

}