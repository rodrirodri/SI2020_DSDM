package br.edu.unisep.todo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.todo.domain.dto.NewTaskDto
import br.edu.unisep.todo.domain.repository.TaskRepository
import kotlinx.coroutines.launch

class NewTaskViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    val saveTaskResult = MutableLiveData<Boolean>()

    fun save(newTask: NewTaskDto) {
        viewModelScope.launch {
            taskRepository.save(newTask)
            saveTaskResult.postValue(true)
        }
    }
}