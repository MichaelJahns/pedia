package com.example.pedia.view

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.pedia.R


class ColorFontFragment : Fragment() {
    private lateinit var metalTitle: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_color_font, container, false)
        bindView(view)
        return view
    }

    private fun bindView(view: View){
        metalTitle = view.findViewById(R.id.metalTitle)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun customTypeface() {
        val metalBuilder = Typeface.Builder(requireActivity().assets, "")
        metalBuilder.setWeight(700)
        metalTitle.typeface = metalBuilder.build()
    }

}