package com.christos.zikas.assessment.utils

import android.content.Context
import android.text.Html
import android.text.Spanned
import com.christos.zikas.assessment.R
import com.christos.zikas.assessment.models.IngredientsModel

class StringUtils {
    companion object {
        fun getAbv(context: Context, abv: Double): String =
            context.getString(R.string.abv, abv.toString())

        fun combineText(first: String, second: String): CharSequence = "$first $second"

        fun generateInfrmation(
            context: Context,
            tagline: String,
            foodPairing: List<String>?,
            ingredients: IngredientsModel?
        ): Spanned {
            val sb = StringBuilder()
            sb.addDoubleBreak(tagline, true)
            if (!foodPairing.isNullOrEmpty())
                sb.addBreak(context.getString(R.string.goes_well_with), true)
            foodPairing?.forEach { sb.addBreak(it) }
            sb.addBreak()

            context.getString(R.string.abv)

            ingredients?.let {
                if (!it.malt.isNullOrEmpty())
                    sb.addBreak(context.getString(R.string.malt), true)
                it.malt?.let { maltList ->
                    maltList.forEach { malt ->
                        sb.addBreak(malt.name)
                        sb.addDoubleBreak("${malt.amount?.value} ${malt.amount?.unit}")
                    }
                }

                if (!it.hops.isNullOrEmpty())
                    sb.addBreak(context.getString(R.string.hops), true)
                it.hops?.let { hopList ->
                    hopList.forEach { hop ->
                        sb.addBreak(hop.name)
                            .addBreak("${hop.amount?.value} ${hop.amount?.unit}")
                            .addDoubleBreak(hop.attribute)
                    }
                }
            }

            return Html.fromHtml(sb.toString(), 0)
        }

        private fun java.lang.StringBuilder.addBreak(text: String = "", isBold: Boolean = false) =
            if (isBold) this.append("<b>$text</b>").append(BREAK_LINE)
            else this.append(text).append(BREAK_LINE)

        private fun java.lang.StringBuilder.addDoubleBreak(
            text: String = "",
            isBold: Boolean = false
        ) =
            if (isBold) this.append("<b>$text</b>").append(DOUBLE_BREAK_LINE)
            else this.append(text).append(DOUBLE_BREAK_LINE)

        private const val BREAK_LINE = "<br>"
        private const val DOUBLE_BREAK_LINE = BREAK_LINE + BREAK_LINE
    }
}


