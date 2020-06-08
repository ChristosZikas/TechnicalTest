package com.christos.zikas.assessment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class HopModel(
    @SerializedName("name") var name: String = "",
    @SerializedName("amount") var amount: AmountModel? = null,
    @SerializedName("add") var add: String = "",
    @SerializedName("attribute") var attribute: String = ""
) : Parcelable