package com.example.pedia.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.pedia.R
import com.example.pedia.di.VariableFontViewModel
import com.example.pedia.view.custom.VariableFontTable
import org.koin.androidx.viewmodel.ext.android.viewModel

@RequiresApi(Build.VERSION_CODES.O)
class ColorFontFragment : Fragment() {
    val viewModel: VariableFontViewModel by viewModel()
    // UI
    private lateinit var nablaTitle: TextView
    private lateinit var nablaDemo: VariableFontTable
    private lateinit var weightPicker: SeekBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_color_font, container, false)
        initView(view)
        initObservers()
        initListeners()
        return view
    }

    private fun initView(view: View){
        nablaTitle = view.findViewById(R.id.nablaTitle)
        nablaDemo = view.findViewById(R.id.nablaDemo)
        weightPicker = view.findViewById(R.id.weightPicker)
    }

    private fun initObservers(){
        viewModel.weight.observe(viewLifecycleOwner) { weight ->
            nablaDemo.updateWeight(weight)
        }
    }
    private fun initListeners() {
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

}