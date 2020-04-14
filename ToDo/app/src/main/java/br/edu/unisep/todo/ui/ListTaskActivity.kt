package br.edu.unisep.todo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.todo.R
import br.edu.unisep.todo.data.db.ToDoDb
import br.edu.unisep.todo.domain.dto.TaskDto
import br.edu.unisep.todo.ui.adapter.ListTaskAdapter
import br.edu.unisep.todo.ui.viewmodel.ListTaskViewModel
import kotlinx.android.synthetic.main.activity_list_task.*

class ListTaskActivity : AppCompatActivity() {

    private val viewModel: ListTaskViewModel by lazy {
        ViewModelProvider(this).get(ListTaskViewModel::class.java)
    }

    private val adapter = ListTaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_task)

        setupList()
    }

    private fun setupList() {
        listTasks.layoutManager = LinearLayoutManager(this)
        listTasks.adapter = adapter

        listTasks.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        viewModel.tasks.observe(this, Observer { onListResult(it) })
        viewModel.findAll()
    }

    private fun onListResult(list: List<TaskDto>) {
        adapter.updateItems(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_todo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menuItemAdd) {
            val intentNewTask = Intent(this, NewTaskActivity::class.java)
            startActivityForResult(intentNewTask, 1)
        }

        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            viewModel.findAll()
        }
    }
}
