package com.christos.zikas.assessment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class BeerModel(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("tagline") var tagline: String = "",
    @SerializedName("abv") var abv: Double = 0.0,
    @SerializedName("first_brewed") var firstBrewed: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("image_url") var imageUrl: String = "",
    @SerializedName("food_pairing") var foodPairing: List<String> = listOf(),
    @SerializedName("ingredients") var ingredients: IngredientsModel? = null
) : Parcelable {

}



