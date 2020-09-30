package com.example.mvvmtutorial.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmtutorial.R
import com.example.mvvmtutorial.model.Country
import com.example.mvvmtutorial.utils.getProgressDrawable
import com.example.mvvmtutorial.utils.loadImage
import kotlinx.android.synthetic.main.item_view.view.*

class  CountryAdapter(val countries:ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    fun updateCountries(newCountries: List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))

    override fun getItemCount(): Int {
return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries.get(position))
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val coutryName=view.name_txt
        private val coutryCapital=view.capital_txt
        private val countryflag=view.flag
        private  val progressDrawable=getProgressDrawable(view.context)

        fun bind(country: Country){
coutryName.text=country.countryName
            coutryCapital.text=country.capital
            countryflag.loadImage(country.flag,progressDrawable)
        }

    }


}