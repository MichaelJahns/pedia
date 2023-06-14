package com.example.pedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pedia.R


class LandingFragment : Fragment() {
    private lateinit var recyclerButton: Button
    private lateinit var newspaperButton: Button
    private lateinit var loudButton: Button
    private lateinit var variableFont: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_landing, container, false)
        bindView(view)
        setListeners()
        return view
    }

    private fun bindView(view: View) {
        recyclerButton = view.findViewById(R.id.recyclerCourier)
        newspaperButton = view.findViewById(R.id.newspaperCourier)
        loudButton = view.findViewById(R.id.loudFragmentCourier)
        variableFont = view.findViewById(R.id.variableFontCourier)
    }

    private fun setListeners(){
        recyclerButton.setOnClickListener {
            findNavController().navigate(R.id.toRecyclerFromLanding)
        }
        newspaperButton.setOnClickListener {
            findNavController().navigate(R.id.toNewspaperFromLanding)
        }
        loudButton.setOnClickListener{
            findNavController().navigate(R.id.toLoudFragmentFromLanding)
        }
        variableFont.setOnClickListener {
            findNavController().navigate(R.id.toVariableFontFromLanding)
        }
    }
}