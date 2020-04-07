package br.edu.unisep.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.todo.R
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_todo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menuItemAdd) {
            //
        }

        return true
    }

}
