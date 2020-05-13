package br.edu.unisep.myexpenses.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.myexpenses.R
import br.edu.unisep.myexpenses.ui.adapter.ExpenseAdapter
import br.edu.unisep.myexpenses.ui.viewmodel.ExpensesViewModel
import kotlinx.android.synthetic.main.activity_expenses.*

class ExpensesActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(ExpensesViewModel::class.java)
    }

    private val adapter = ExpenseAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        setupList()
        setupObservers()

        viewModel.findAll()
    }

    private fun setupList() {
        listExpenses.adapter = adapter
        listExpenses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listExpenses.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun setupObservers() {
        viewModel.listExpenses.observe(this, Observer { items ->
            adapter.updateItems(items)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_expenses, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuNewExpense) {
            val intent = Intent(this, NewExpenseActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_NEW_EXPENSE)
        }

        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_NEW_EXPENSE && resultCode == RESULT_OK) {
            viewModel.findAll()
        }
    }

    companion object {
        private const val REQUEST_CODE_NEW_EXPENSE = 1
    }

}
