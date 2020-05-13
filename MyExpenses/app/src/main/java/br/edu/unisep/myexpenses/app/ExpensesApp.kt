package br.edu.unisep.myexpenses.app

import android.app.Application
import br.edu.unisep.myexpenses.model.db.ExpenseDb

class ExpensesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ExpenseDb.createInstance(applicationContext)
    }
}