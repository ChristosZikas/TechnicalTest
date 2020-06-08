package com.christos.zikas.assessment.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.ui.AdapterHandler
import com.christos.zikas.assessment.utils.StringUtils
import kotlinx.android.synthetic.main.rv_beer_list.view.*

class BeerListAdapter(private val handler: AdapterHandler) :
    RecyclerView.Adapter<BeerListAdapter.BeerVH>() {

    val beerModelList = mutableListOf<BeerModel>()

    private val options = RequestOptions()
        .centerInside()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_beer_list, parent, false)
        return BeerVH(view)
    }

    override fun getItemCount(): Int = beerModelList.size

    override fun onBindViewHolder(holder: BeerVH, position: Int) {
        if (position == beerModelList.size - 1) handler.load()

        val beer = beerModelList[position]

        holder.setViews(beer, options)
        holder.itemView.setOnClickListener { handler.selectBeer(beer) }
    }

    class BeerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setViews(beer: BeerModel, options: RequestOptions) {
            Glide.with(itemView.product_image_iv)
                .load(beer.imageUrl)
                .apply(options)
                .into(itemView.product_image_iv)

            itemView.title_tv.text = StringUtils.combineText(beer.name, beer.firstBrewed)
            itemView.abv_tv.text = StringUtils.getAbv(itemView.context, beer.abv)
        }
    }
}