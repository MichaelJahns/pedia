package com.example.pedia.view.fontdemos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pedia.R
import com.example.pedia.view.fontdemos.custom.GridViewFontAdapter
import com.example.pedia.view.fontdemos.custom.VariableFontModel

class VariableFontGridFragment : Fragment() {
    lateinit var gridView: GridView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_variable_font_grid, container, false)
        gridView = view.findViewById(R.id.font_grid_view)
        val fonts = getVariableFontModels()
        val adapter = GridViewFontAdapter(requireContext(), fonts)
        gridView.adapter = adapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(), "You CLicked " + fonts[+position],
                Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }

    private fun getVariableFontModels(): List<VariableFontModel> {
        val beyondregular = VariableFontModel(
            name = "Alpha Beyond Regular",
            fontFamilyPath = "fonts/beyond_regular.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val cinzeldecorative = VariableFontModel(
            name = "Cinzel Decorative",
            fontFamilyPath = "fonts/cinzel_decorative.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val foldit = VariableFontModel(
            name = "Fold it",
            fontFamilyPath = "fonts/foldit.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val luciuscypher = VariableFontModel(
            name = "Lucius Cypher",
            fontFamilyPath = "fonts/lucuis_cypher.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val nabla = VariableFontModel(
            name = "Nabla",
            fontFamilyPath = "fonts/nabla.ttf",
            axes = listOf("Edge Extrusion", "Edge Highlight"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val pigpencypher = VariableFontModel(
            name = "Pig Pen Cypher",
            fontFamilyPath = "fonts/pig_pen_cypher.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val queenserif = VariableFontModel(
            name = "Queen Serif",
            fontFamilyPath = "fonts/queen_serif.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val robotomono = VariableFontModel(
            name = "Roboto Mono",
            fontFamilyPath = "fonts/roboto_mono.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )
        val wetcalligraphy = VariableFontModel(
            name = "Wet Calligraphy",
            fontFamilyPath = "fonts/wet_calligraphy.ttf",
            axes = listOf("wght"),
            minWeight = 1,
            maxWeight = 1000,
        )

        return listOf(beyondregular, luciuscypher, cinzeldecorative, nabla, pigpencypher, queenserif, robotomono, wetcalligraphy)
    }

}