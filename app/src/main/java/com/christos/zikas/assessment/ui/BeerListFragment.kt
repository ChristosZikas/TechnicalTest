package com.christos.zikas.assessment.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.AdapterHandler
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.utils.adapters.BeerListAdapter
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import com.christos.zikas.assessment.view_models.BeerListVM
import kotlinx.android.synthetic.main.fragment_beer_list.*
import javax.inject.Inject

data class LoadItemEvent(val selectedItem: BeerModel)

@SetContentView(layout = R.layout.fragment_beer_list)
class BeerListFragment : BaseFragment(), AdapterHandler {

    @Inject
    lateinit var viewModel: BeerListVM

    private val adapter = BeerListAdapter(this)

    override fun selectBeer(selectedItem: BeerModel) = post(LoadItemEvent(selectedItem))

    override fun load(nextPage: Int) {
        viewModel.retrieveNextPage(nextPage)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObserver()
        setAdapter()
    }

    private fun setAdapter() {
        beer_list_rv.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        beer_list_rv.layoutManager = layoutManager
        if (adapter.beerModelList.isEmpty()) viewModel.retrieveNextPage(1)
    }

    private fun setObserver() {
        viewModel.itemsRetrieved().observe(viewLifecycleOwner, Observer {
            if (loader_fl.visibility == View.VISIBLE) loader_fl.visibility = View.GONE
            adapter.beerModelList.addAll(it)
            adapter.notifyDataSetChanged()
        })

        viewModel.setLoader().observe(viewLifecycleOwner, Observer {
            if (loader_fl.visibility == View.GONE) loader_fl.visibility = View.VISIBLE
        })
    }

}