package br.edu.unisep.todo.app

import android.app.Application
import br.edu.unisep.todo.data.db.ToDoDb

class ToDoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ToDoDb.createInstance(applicationContext)
    }
}