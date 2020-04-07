package br.edu.unisep.todo.domain.repository

import br.edu.unisep.todo.data.db.ToDoDb
import br.edu.unisep.todo.data.entity.Task
import br.edu.unisep.todo.domain.dto.NewTaskDto
import br.edu.unisep.todo.domain.dto.TaskDto

class TaskRepository {

    private val taskDao = ToDoDb.getInstance().getTaskDao()

    suspend fun findAll(): List<TaskDto> {
        val result = taskDao.findAll()
        return result.map { t ->
            TaskDto(t.id ?: 0, t.title, t.description, t.priority)
        }
    }

    suspend fun save(newTask: NewTaskDto) {
        val task = Task(newTask.title, newTask.description, newTask.priority)
        taskDao.save(task)
    }
}