package com.example.pedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class RecyclerFragment : Fragment() {
    private lateinit var navButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        navButton = view.findViewById(R.id.button)
        navButton.setOnClickListener{
            navigateToLanding()
        }
        // Call off of main thread
        val text = resources.openRawResource(R.raw.example).bufferedReader().use{
            it.readText()
        }
        // Interesting question. Normally during the retrofit call JSON strings are transformed into a collection of Objects
        // I did this approach in an attempt to do things 'in-order' but how does one make that transformation without a
        // Retrofit implementation. Certainly I still need a data class.

        return view

    }


    private fun navigateToLanding() {
        findNavController().navigate(R.id.toLandingFromRecycler)
    }
}