package com.example.pedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.pedia.R

class NewspaperFragment : Fragment() {
    private lateinit var acceptButton: Button
    private lateinit var denyButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newspaper, container, false)
        bindView(view)
        setListeners()
        return view
    }

    private fun bindView(view: View) {
        acceptButton = view.findViewById(R.id.accept_button)
        denyButton = view.findViewById(R.id.deny_button)
    }

    private fun setListeners() {
        acceptButton.setOnClickListener { navigateToLanding() }
        denyButton.setOnClickListener { navigateToLanding() }
    }

    private fun navigateToLanding() {
        findNavController().navigate(R.id.toLandingFromNewspaper)
    }
}