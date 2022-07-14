package com.example.coinapp.ui.coins.adapters

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.R
import com.example.coinapp.data.model.coin.CoinModel
import com.example.coinapp.databinding.CoinItemBinding
import kotlin.math.roundToLong

class CoinFragmentViewHolder(
    view: View,
    private val binding: CoinItemBinding
) : RecyclerView.ViewHolder(view) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun bindData(coin: CoinModel, onClickListener: (CoinModel) -> Unit) {
        binding.apply {
            var percent = coin.quote.USD.percent_change_24h.toFloat() * 100
            percent = ((percent * 100).roundToLong() / 100).toFloat()

            var price = coin.quote.USD.price.toFloat() * 100
            price = ((price * 100).roundToLong() / 100).toFloat()

            textViewTittle.text = coin.name
            textViewSymbol.text = coin.symbol
            textViewPrice.text = "$${price}"

        }
        itemView.setOnClickListener { onClickListener(coin) }
    }
}