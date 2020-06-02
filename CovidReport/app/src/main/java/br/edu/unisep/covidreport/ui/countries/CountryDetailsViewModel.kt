package br.edu.unisep.covidreport.ui.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.domain.dto.TotalDto
import br.edu.unisep.covidreport.domain.repository.CovidRepository
import kotlinx.coroutines.launch

class CountryDetailsViewModel : ViewModel() {

    private val repository = CovidRepository()

    val countryTotals = MutableLiveData<ApiResult<TotalDto>>()

    fun getCountryTotals(country: CountryDto) {
        viewModelScope.launch {
            val totals = repository.getTotalsByCountry(country)
            countryTotals.postValue(totals)
        }
    }

}