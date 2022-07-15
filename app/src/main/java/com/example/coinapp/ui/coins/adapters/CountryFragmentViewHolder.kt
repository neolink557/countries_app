package com.example.coinapp.ui.coins.adapters

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coinapp.data.model.countries.CountryModel
import com.example.coinapp.databinding.CountryItemBinding

class CountryFragmentViewHolder(
    view: View,
    private val binding: CountryItemBinding
) : RecyclerView.ViewHolder(view) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun bindData(country: CountryModel, onClickListener: (CountryModel) -> Unit) {
        binding.apply {


            textViewTittle.text = country.name
            textViewCity.text = country.capital
            textViewContinent.text = country.continent.name
            Glide.with(imageView).load("https://countryflagsapi.com/png/${country.code}").centerCrop().into(imageView)
            Glide.with(layoutBg).load("https://countryflagsapi.com/png/${country.code}").centerCrop().into(layoutBg)

            layout.setOnClickListener { onClickListener(country) }
        }

    }
}