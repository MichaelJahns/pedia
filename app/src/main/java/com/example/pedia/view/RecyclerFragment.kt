package com.example.pedia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pedia.R
import com.example.pedia.util.CustomAdapter
import com.example.pedia.datamodels.CountryList
import com.google.gson.Gson


class RecyclerFragment : Fragment() {
    private lateinit var navButton : Button
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter: CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        bindView(view)
        setListeners()
        // Call off of main thread
        val json: String = readJson()
        var gson = Gson()
        val countryList = gson.fromJson(json, CountryList::class.java)
        recyclerView.adapter = CustomAdapter(countryList)
        return view
    }
    private fun bindView(view: View){
        navButton = view.findViewById(R.id.button)
        recyclerView = view.findViewById(R.id.recycler)
    }
    private fun setListeners(){
        navButton.setOnClickListener{
            findNavController().navigate(R.id.toLandingFromRecycler)
        }
    }
    private fun readJson(): String{
        // Interesting question. Normally during the retrofit call JSON strings are transformed into a collection of Objects
        // I did this approach in an attempt to do things 'in-order' but how does one make that transformation without a
        // Retrofit implementation. Certainly I still need a data class.
        resources.openRawResource(R.raw.example).bufferedReader().use{
            return it.readText()
        }
    }
}