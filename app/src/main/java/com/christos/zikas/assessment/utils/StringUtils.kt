package com.christos.zikas.assessment.utils

class StringUtils {
    companion object {
        fun getAbv(abv: Double): CharSequence = "ABV - $abv"
        fun combineText(first: String, second: String): CharSequence = "$first $second"
    }
}
