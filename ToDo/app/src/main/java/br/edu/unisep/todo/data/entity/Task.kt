package br.edu.unisep.todo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(var title: String,
                var description: String,
                var priority: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}