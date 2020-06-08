package com.christos.zikas.assessment.ui

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.utils.StringUtils
import com.christos.zikas.assessment.utils.base_ui.BaseFragment
import com.christos.zikas.assessment.utils.base_ui.SetContentView
import kotlinx.android.synthetic.main.fragment_selected_beer.*

@SetContentView(layout = R.layout.fragment_selected_beer)
class SelectedBeerFragment : BaseFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<BeerModel>(getString(R.string.selected_item))?.let {

            val options = RequestOptions()
                .centerInside()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)

            Glide.with(this).load(it.imageUrl).apply(options).into(product_image_iv)
            item_name_tv.text = it.name
            item_date_tv.text = it.firstBrewed
            abv_tv.text = StringUtils.getAbv(context!!, it.abv)
            description_tv.text = it.description
            information_tv.text = StringUtils.generateInfrmation(
                context!!,
                it.tagline,
                it.foodPairing,
                it.ingredients
            )
        }
    }
}
