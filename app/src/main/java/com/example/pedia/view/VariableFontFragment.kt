package com.example.pedia.view

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pedia.R
import com.example.pedia.di.VariableFontViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@RequiresApi(Build.VERSION_CODES.O)
class VariableFontFragment : Fragment() {
    val viewModel: VariableFontViewModel by viewModel()
    private lateinit var text400Builder: Typeface.Builder
    private lateinit var text700Builder: Typeface.Builder
    private lateinit var text900Builder: Typeface.Builder

    //  UI
    private lateinit var textW400: TextView
    private lateinit var textW700: TextView
    private lateinit var textW900: TextView
    private lateinit var weightValue: TextView
    private lateinit var weightPicker: SeekBar
    private lateinit var colorFontButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_variable_font_demo, container, false)
        initView(view)
        initObservers()
        setListeners()
        return view
    }

    private fun initView(view: View) {
        bindView(view)
        text400Builder = Typeface.Builder(requireActivity().assets, "fonts/cinzel_decorative.ttf")
        text700Builder = Typeface.Builder(requireActivity().assets, "fonts/cinzel_decorative.ttf")
        text900Builder = Typeface.Builder(requireActivity().assets, "fonts/cinzel_decorative.ttf")
    }

    private fun bindView(view: View) {
        textW400 = view.findViewById(R.id.weight400)
        textW700 = view.findViewById(R.id.weight700)
        textW900 = view.findViewById(R.id.weight900)
        weightValue = view.findViewById(R.id.weightValue)
        weightPicker = view.findViewById(R.id.weightPicker)
        colorFontButton = view.findViewById(R.id.colorFontCourier)
    }

    private fun initObservers() {
        viewModel.weight.observe(viewLifecycleOwner) { weight ->
            setBuilderWeights(weight)
            weightValue.text = weight.toString()
        }
    }

    private fun setListeners() {
        colorFontButton.setOnClickListener {
            findNavController().navigate(R.id.toColorFontFromVariableFont)
        }
        weightPicker.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, p1: Int, p2: Boolean) {
                viewModel.setWeight(seekBar.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }

    private fun setBuilderWeights(weight: Int) {
        text400Builder.setFontVariationSettings("'wght' ${weight}, 'slnt' 20, 'ital' 1")
        text400Builder.setWeight(weight)
        text700Builder.setFontVariationSettings("'wght' ${weight + 300}, 'slnt' 20, 'ital' 1")
        text700Builder.setWeight(weight + 300)
        text900Builder.setFontVariationSettings("'wght' ${weight + 500}, 'slnt' 20, 'ital' 1")
        text900Builder.setWeight(weight + 500)
        buildStrings()
    }

    private fun buildStrings() {
        textW400.typeface = text400Builder.build()
        textW700.typeface = text700Builder.build()
        textW900.typeface = text900Builder.build()
    }
}