package com.christos.zikas.assessment.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.utils.adapters.BeerListAdapter
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import com.christos.zikas.assessment.view_models.BeerListVM
import kotlinx.android.synthetic.main.fragment_beer_list.*
import javax.inject.Inject

interface AdapterHandler {
    fun load()
    fun selectBeer(selectedItem: BeerModel)
}

data class LoadItemEvent(val selectedItem: BeerModel)

@SetContentView(layout = R.layout.fragment_beer_list)
class BeerListFragment : BaseFragment(), AdapterHandler {

    var update = false

    override fun selectBeer(selectedItem: BeerModel) {
        post(LoadItemEvent(selectedItem))
    }

    override fun load() {
        adapter.size += 10
        Handler().postDelayed(
            {
                adapter.notifyDataSetChanged()
            }, 300
        )
    }


    @Inject
    lateinit var viewModel: BeerListVM

    val adapter = BeerListAdapter(this)


    @SuppressLint("CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        beer_list_rv.adapter = adapter

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        beer_list_rv.layoutManager = layoutManager

    }

}