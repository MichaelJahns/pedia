package com.example.pedia.view.fontdemos

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.pedia.R
import com.example.pedia.di.VariableFontViewModel
import com.example.pedia.view.fontdemos.custom.VariableFontFragment
import com.example.pedia.view.fontdemos.custom.VariableFontDemoTable
import org.koin.androidx.viewmodel.ext.android.viewModel

@RequiresApi(Build.VERSION_CODES.O)
class CinzelDecorativeFragment : VariableFontFragment() {
    val viewModel: VariableFontViewModel by viewModel()
    //  UI
    private lateinit var cinzelTitle: TextView
    private lateinit var cinzelDemo: VariableFontDemoTable
    private lateinit var weightPicker: SeekBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_demo_cinzel_decorative, container, false)
        initView(view)
        initObservers()
        initListeners()
        return view
    }

    private fun initView(view: View) {
        cinzelTitle = view.findViewById(R.id.cinzelTitle)
        cinzelDemo = view.findViewById(R.id.cinzelDemo)
        weightPicker = view.findViewById(R.id.weightPicker)
    }

    private fun initObservers() {
        viewModel.weight.observe(viewLifecycleOwner) { weight ->
            cinzelDemo.updateWeight(weight)
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