package com.christos.zikas.assessment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class IngredientsModel(
    @SerializedName("malt") var malt: List<MaltModel>? = null,
    @SerializedName("hops") var hops: List<HopModel>? = null,
    @SerializedName("yeast") var yeast: String = ""
) : Parcelable