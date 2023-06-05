package com.example.pedia.view.custom

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.example.pedia.R
import kotlin.math.absoluteValue

@RequiresApi(Build.VERSION_CODES.O)
class VariableFontTable(
    context: Context,
    attrs: AttributeSet
) : LinearLayout(context, attrs) {
    private var displayText: String
    private var fontFamilyString: String
    private lateinit var minWeight: VariableFontRow
    private lateinit var weightMinus200: VariableFontRow
    private lateinit var currentWeight: VariableFontRow
    private lateinit var weightPlus200: VariableFontRow
    private lateinit var weightPlus400: VariableFontRow
    private lateinit var weightPlus600: VariableFontRow
    private lateinit var maxWeight: VariableFontRow

    init {
        inflate(context, R.layout.variable_font_table, this)
        val custom = context.obtainStyledAttributes(attrs, R.styleable.VariableFontTable, 0, 0)
        try {
            displayText = custom.getString(R.styleable.VariableFontTable_displayText)!!
            fontFamilyString = custom.getString(R.styleable.VariableFontTable_fontFamilyPath)!!
            bindView()
            setString(displayText)
            setFontFamily(fontFamilyString)
        } finally {
            custom.recycle()
        }
    }

    private fun bindView() {
        minWeight = findViewById(R.id.minWeight)
        weightMinus200 = findViewById(R.id.weightMinus200)
        currentWeight = findViewById(R.id.currentWeight)
        weightPlus200 = findViewById(R.id.weightPlus300)
        weightPlus400 = findViewById(R.id.weightPlus500)
        weightPlus600 = findViewById(R.id.weightPlus700)
        maxWeight = findViewById(R.id.maxWeight)
    }

    private fun setString(displayText: String) {
        minWeight.updateTitle(displayText)
        weightMinus200.updateTitle(displayText)
        currentWeight.updateTitle(displayText)
        weightPlus200.updateTitle(displayText)
        weightPlus400.updateTitle(displayText)
        weightPlus600.updateTitle(displayText)
        maxWeight.updateTitle(displayText)
    }

    private fun setFontFamily(fontFamilyPath: String) {
        minWeight.updateFontFamily(fontFamilyPath)
        weightMinus200.updateFontFamily(fontFamilyPath)
        currentWeight.updateFontFamily(fontFamilyPath)
        weightPlus200.updateFontFamily(fontFamilyPath)
        weightPlus400.updateFontFamily(fontFamilyPath)
        weightPlus600.updateFontFamily(fontFamilyPath)
        maxWeight.updateFontFamily(fontFamilyPath)
    }

    fun updateWeight(weight: Int) {
        minWeight.updateWeight(1)
        weightMinus200.updateWeight(weight - 200)
        currentWeight.updateWeight(weight)
        weightPlus200.updateWeight(weight + 200)
        weightPlus400.updateWeight(weight + 400)
        weightPlus600.updateWeight(weight + 600)
        maxWeight.updateWeight(1000)
    }
}