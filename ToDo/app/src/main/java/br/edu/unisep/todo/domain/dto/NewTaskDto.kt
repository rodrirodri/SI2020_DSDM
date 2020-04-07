package br.edu.unisep.todo.domain.dto

data class NewTaskDto(
    val title: String,
    val description: String,
    val priority: Int
)