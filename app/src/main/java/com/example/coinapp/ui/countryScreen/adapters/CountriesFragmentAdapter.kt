package com.example.coinapp.ui.countryScreen.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.data.model.countries.CountryModel
import com.example.coinapp.databinding.CountryItemBinding

class CountriesFragmentAdapter(
    private val countries: List<CountryModel>,
    private val onClickListener:(CountryModel)-> Unit
) : RecyclerView.Adapter<CountryFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryFragmentViewHolder {
        val viewBinding = CountryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountryFragmentViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = countries.size

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: CountryFragmentViewHolder, position: Int) =
        holder.bindData(countries[position],onClickListener)

}