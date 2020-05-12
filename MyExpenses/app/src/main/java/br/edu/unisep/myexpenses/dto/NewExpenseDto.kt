package br.edu.unisep.myexpenses.dto

data class NewExpenseDto(
    val description: String,
    val value: Double,
    val date: String
)