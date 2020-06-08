package com.christos.zikas.assessment.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.ui.AdapterHandler

class BeerListAdapter(private val handler: AdapterHandler) : RecyclerView.Adapter<BeerListAdapter.BeerVH>() {

    var size = 10

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_beer_list, parent, false)
        return BeerVH(view)
    }

    override fun getItemCount(): Int = size

    override fun onBindViewHolder(holder: BeerVH, position: Int) {
        if (position == size - 1) handler.load()

        val item = BeerModel().apply {
            id = 1
            name = "name"
            tagline = "asd"
            abv = 4.4
            firstBrewed = "asd"
            description = "descript"
            imageUrl = "https://images.punkapi.com/v2/keg.png"
        }

        holder.itemView.setOnClickListener { handler.selectBeer(item) }

    }

    class BeerVH(itemView: View) : RecyclerView.ViewHolder(itemView)
}