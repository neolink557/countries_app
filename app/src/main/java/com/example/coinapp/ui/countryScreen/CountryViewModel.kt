package com.example.coinapp.ui.countryScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.data.model.countries.CountriesModelList
import com.example.coinapp.data.model.states.State
import com.example.coinapp.domain.GetCountriesUseCase
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    private val countriesUseCase = GetCountriesUseCase()
    val countryModel = MutableLiveData<Pair<State, CountriesModelList?>>()


    fun getCountries(){
        viewModelScope.launch {
            countryModel.postValue(Pair(State.LOADING,null))

            val result =  countriesUseCase()

            if (result != null){
                countryModel.postValue(Pair(State.SUCCESS,result))
            }else{
                countryModel.postValue(Pair(State.ERROR,result))
            }
        }
    }


}