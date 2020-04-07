package br.edu.unisep.todo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.todo.domain.dto.TaskDto
import br.edu.unisep.todo.domain.repository.TaskRepository
import kotlinx.coroutines.launch

class ListTaskViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    val tasks = MutableLiveData<List<TaskDto>>()

    fun findAll() {
        viewModelScope.launch {
            val result = taskRepository.findAll()
            tasks.postValue(result)
        }
    }
}