package com.christos.zikas.assessment.ui

import android.os.Bundle
import android.util.Log
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import javax.inject.Inject

@SetContentView(layout = R.layout.fragment_beer_list)
class BeerListFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: BeerListFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
