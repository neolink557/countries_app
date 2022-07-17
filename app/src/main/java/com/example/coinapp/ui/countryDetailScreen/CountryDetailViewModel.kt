package com.example.coinapp.ui.countryDetailScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapp.data.model.countries.CountriesModelList
import com.example.coinapp.data.model.countries.CountryDetailModel
import com.example.coinapp.data.model.states.State
import com.example.coinapp.domain.GetCountriesUseCase
import com.example.coinapp.domain.GetCountryDetailUseCase
import kotlinx.coroutines.launch

class CountryDetailViewModel : ViewModel() {
    private val countryUseCase = GetCountryDetailUseCase()
    val countryModel = MutableLiveData<Pair<State, CountryDetailModel?>>()


    fun getCountries(code:String){
        viewModelScope.launch {
            countryModel.postValue(Pair(State.LOADING,null))

            val result =  countryUseCase(code)

            if (result != null){
                countryModel.postValue(Pair(State.SUCCESS,result))
            }else{
                countryModel.postValue(Pair(State.ERROR,result))
            }
        }
    }
}