package com.example.pedia.view.fontdemos.custom

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.pedia.R

class GridViewFontAdapter(
    private val context: Context,
    private val fonts: List<VariableFontModel>
) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var briefDemo: TextView
    private lateinit var fontName: TextView
    override fun getCount(): Int {
        return fonts.size
    }

    override fun getItem(position: Int): VariableFontModel {
        return fonts[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (view == null) {
            view = layoutInflater!!.inflate(R.layout.grid_item_font, null)
        }
        briefDemo = view!!.findViewById(R.id.font_abc)
        briefDemo.typeface = Typeface.createFromAsset(context.assets, fonts[position].fontFamilyPath)
        fontName = view.findViewById(R.id.font_name)
        fontName.text = fonts[position].name
        return view

    }
}