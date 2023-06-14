package com.example.pedia.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pedia.R
import com.example.pedia.datamodels.Country

class CustomAdapter(
    private val countryList: List<Country>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val country: TextView
        val region: TextView
        val capitol: TextView

        init {
            country = view.findViewById(R.id.country)
            region = view.findViewById(R.id.region)
            capitol = view.findViewById(R.id.captiol)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.country.text = countryList[position].name
        holder.region.text = countryList[position].region
        holder.capitol.text = countryList[position].capital
    }

}
