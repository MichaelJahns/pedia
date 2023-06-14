package com.example.pedia.view.fontdemos.custom

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.pedia.R

@RequiresApi(Build.VERSION_CODES.O)
class VariableFontDemoRow(
    context: Context,
    attrs: AttributeSet
) : LinearLayout(context, attrs) {
    private lateinit var fontFamilyPath: String
    private lateinit var weightTV: TextView
    private lateinit var displayTV: TextView

    init {
        inflate(context, R.layout.variable_font_row, this)
        val custom = context.obtainStyledAttributes(attrs, R.styleable.VariableFontRow, 0, 0)
        try {
            bindView()
        } finally {
            custom.recycle()
        }
    }

    private fun bindView() {
        weightTV = findViewById(R.id.weight)
        displayTV = findViewById(R.id.displayText)
    }

    fun updateTitle(string: String) {
        displayTV.text = string
    }

    fun updateFontFamily(fontFamilyPath: String) {
        this.fontFamilyPath = fontFamilyPath
    }

    fun updateWeight(weight: Int) {
        val noNegativeWeights = if (weight > 1) weight else 1
        displayTV.typeface = Typeface.Builder(context.assets, fontFamilyPath)
            .setFontVariationSettings("'wght' $noNegativeWeights").build()
        weightTV.text = noNegativeWeights.toString()
    }
}