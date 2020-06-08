package com.christos.zikas.assessment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.SplashScreenCompletedEvent
import com.christos.zikas.assessment.utils.base_ui.BaseActivity
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import com.christos.zikas.assessment.utils.eventbus.RegisterBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@RegisterBus
@SetContentView(layout = R.layout.activity_main)
class TechTestActivity : BaseActivity() {

    private val beerListFragment by lazy { BeerListFragment() }
    private val selectedBeerFragment by lazy { SelectedBeerFragment() }

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

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun on(e: SplashScreenCompletedEvent) {
        replaceFragment(beerListFragment)
        removeSticky(SplashScreenCompletedEvent::class.java)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun on(e: LoadItemEvent) {
        val bundle =
            Bundle().apply { putParcelable(getString(R.string.selected_item), e.selectedItem) }
        selectedBeerFragment.arguments = bundle
        replaceFragment(selectedBeerFragment)
        removeSticky(LoadItemEvent::class.java)
    }

}
