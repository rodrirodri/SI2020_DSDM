package br.edu.unisep.myexpenses.repository

import br.edu.unisep.myexpenses.dto.ExpenseDto
import br.edu.unisep.myexpenses.dto.NewExpenseDto
import br.edu.unisep.myexpenses.model.db.ExpenseDb
import br.edu.unisep.myexpenses.model.entity.Expense

class ExpenseRepository {

    private val expenseDao = ExpenseDb.getInstance().getExpenseDao()

    suspend fun save(newExpense: NewExpenseDto) {
        val expense = Expense(newExpense.description, newExpense.date, newExpense.value)
        expenseDao.save(expense)
    }

    suspend fun findAll(): List<ExpenseDto> {
        val expenses = expenseDao.findAll()

        return expenses.map { e ->
            ExpenseDto(
                e.id ?: 0,
                e.description,
                e.value,
                e.date
            )
        }
    }

}