package com.christos.zikas.assessment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.utils.base_ui.BaseActivity
import com.christos.zikas.assessment.utils.base_ui.SetContentView

@SetContentView(layout = R.layout.activity_main)
class TechTestActivity : BaseActivity() {

    val beerListFragment by lazy { BeerListFragment() }
    val selectedBeerFragment by lazy { SelectedBeerFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(SplashScreenFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }

}
