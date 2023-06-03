package com.example.pedia.view

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.pedia.R
import org.w3c.dom.Text

@RequiresApi(Build.VERSION_CODES.O)
class VariableFontFragment : Fragment() {
    private lateinit var typefaceBuilder: Typeface.Builder
    //  UI
    private lateinit var textW400: TextView
    private lateinit var textW700: TextView
    private lateinit var textW900: TextView
    private lateinit var colorFontButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_variable_font_demo, container, false)
        bindView(view)
        setListeners()
        getTypefaceBuilder()
        buildStrings()
        return view
    }

    private fun bindView(view: View) {
        colorFontButton = view.findViewById(R.id.colorFontCourier)
        textW400 = view.findViewById(R.id.weight400)
        textW700 = view.findViewById(R.id.weight700)
        textW900 = view.findViewById(R.id.weight900)
    }

    private fun setListeners() {
        colorFontButton.setOnClickListener {
            findNavController().navigate(R.id.toColorFontFromVariableFont)
        }
    }

    private fun getTypefaceBuilder() {
        typefaceBuilder =
            Typeface.Builder(requireActivity().assets, "cinzel_decorative.ttf")
    }

    private fun buildStrings() {
        textW400.typeface = typefaceBuilder.build()
        textW700.typeface = typefaceBuilder.build()
        textW900.typeface = typefaceBuilder.build()
    }
}