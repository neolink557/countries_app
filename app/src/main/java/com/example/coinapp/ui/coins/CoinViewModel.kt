package com.example.coinapp.ui.coins

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.data.model.coin.CoinModelList
import com.example.coinapp.data.model.coindetail.CoinDetail
import com.example.coinapp.data.model.states.State
import com.example.coinapp.domain.GetCoinDetailUseCase
import com.example.coinapp.domain.GetCoinsUseCase
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    private val coinUseCase = GetCoinsUseCase()
    private val coinDetailUseCase = GetCoinDetailUseCase()

    val coinsModel = MutableLiveData<Pair<State,CoinModelList?>>()
    val coinsDetail = MutableLiveData<Pair<State, CoinDetail?>>()

    fun getLessonsDetail(){
        viewModelScope.launch {
            coinsModel.postValue(Pair(State.LOADING,null))
            val result = coinUseCase()

            if (result != null){
                coinsModel.postValue(Pair(State.SUCCESS,result))
            }else{
                coinsModel.postValue(Pair(State.ERROR,result))
            }
        }
    }

    fun getLessonsDetail(symbol:String){
        viewModelScope.launch {
            coinsDetail.postValue(Pair(State.LOADING,null))
            val result = coinDetailUseCase(symbol)

            if (result != null){
                coinsDetail.postValue(Pair(State.SUCCESS,result))
            }else{
                coinsDetail.postValue(Pair(State.ERROR,result))
            }
        }
    }


}