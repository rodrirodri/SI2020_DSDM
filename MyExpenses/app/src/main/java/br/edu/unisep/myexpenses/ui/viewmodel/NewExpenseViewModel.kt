package br.edu.unisep.myexpenses.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.myexpenses.dto.NewExpenseDto
import br.edu.unisep.myexpenses.repository.ExpenseRepository
import kotlinx.coroutines.launch

class NewExpenseViewModel : ViewModel() {

    private val repository = ExpenseRepository()

    val saveExpenseResult = MutableLiveData<Boolean>()

    fun save(newExpense: NewExpenseDto) {
        viewModelScope.launch {
            repository.save(newExpense)
            saveExpenseResult.postValue(true)
        }
    }


}