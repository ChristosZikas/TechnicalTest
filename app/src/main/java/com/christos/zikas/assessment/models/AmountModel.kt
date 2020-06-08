package com.christos.zikas.assessment.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class AmountModel(
    @SerializedName("value") var value: Double = 0.0,
    @SerializedName("unit") var unit: String = ""
) : Parcelable