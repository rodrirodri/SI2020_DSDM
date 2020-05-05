package br.edu.unisep.covidreport.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.TotalDto
import br.edu.unisep.covidreport.domain.repository.CovidRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = CovidRepository()

    val totals = MutableLiveData<ApiResult>()

    fun getTotals() {
        viewModelScope.launch {
            val result = repository.getTotals()
            totals.postValue(result)
        }
    }

}