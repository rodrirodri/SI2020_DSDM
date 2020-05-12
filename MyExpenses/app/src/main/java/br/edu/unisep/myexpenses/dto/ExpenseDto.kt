package br.edu.unisep.myexpenses.dto

data class ExpenseDto(
    val id: Int,
    val description: String,
    val value: Double,
    val date: String
)