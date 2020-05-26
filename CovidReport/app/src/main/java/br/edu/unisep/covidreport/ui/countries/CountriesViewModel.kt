package br.edu.unisep.covidreport.ui.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.repository.CovidRepository
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val repository = CovidRepository()

    val countries = MutableLiveData<ApiResult>()

    fun getCountries() {
        viewModelScope.launch {
            val result = repository.getCountries()
            countries.postValue(result)
        }
    }



}