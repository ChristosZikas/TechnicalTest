package com.christos.zikas.assessment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class MaltModel(
    @SerializedName("name") var name: String = "",
    @SerializedName("amount") var amount: AmountModel? = null
) : Parcelable