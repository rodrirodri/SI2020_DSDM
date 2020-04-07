package br.edu.unisep.todo.domain.dto

data class TaskDto(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int
)