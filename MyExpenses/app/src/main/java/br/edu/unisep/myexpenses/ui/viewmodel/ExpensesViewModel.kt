package br.edu.unisep.myexpenses.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.myexpenses.dto.ExpenseDto
import br.edu.unisep.myexpenses.repository.ExpenseRepository
import kotlinx.coroutines.launch

class ExpensesViewModel : ViewModel() {

    private val repository = ExpenseRepository()

    val listExpenses = MutableLiveData<List<ExpenseDto>>()

    fun findAll() {
        viewModelScope.launch {
            val result = repository.findAll()
            listExpenses.postValue(result)
        }
    }
}