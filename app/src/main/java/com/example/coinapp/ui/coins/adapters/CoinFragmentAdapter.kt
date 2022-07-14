package com.example.coinapp.ui.coins.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.data.model.coin.CoinModel
import com.example.coinapp.databinding.CoinItemBinding

class CoinFragmentAdapter(
    private val coins: List<CoinModel>,
    private val onClickListener:(CoinModel)-> Unit
) : RecyclerView.Adapter<CoinFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinFragmentViewHolder {
        val viewBinding = CoinItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinFragmentViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = coins.size

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: CoinFragmentViewHolder, position: Int) =
        holder.bindData(coins[position],onClickListener)

}