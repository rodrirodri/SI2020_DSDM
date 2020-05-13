package br.edu.unisep.myexpenses.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.unisep.myexpenses.R
import br.edu.unisep.myexpenses.dto.NewExpenseDto
import br.edu.unisep.myexpenses.ui.viewmodel.NewExpenseViewModel
import kotlinx.android.synthetic.main.activity_new_expense.*

class NewExpenseActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(NewExpenseViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_expense)

        setupListeners()
    }

    private fun setupListeners() {
        buttonSave.setOnClickListener { save() }
        viewModel.saveExpenseResult.observe(this, Observer { returnToList() })
    }

    private fun save() {
        val newExpense = NewExpenseDto(
            editTextDescription.text.toString(),
            editTextValue.text.toString().toDouble(),
            editTextDate.text.toString()
        )

        viewModel.save(newExpense)
    }

    private fun returnToList() {
        setResult(RESULT_OK)
        finish()
    }

}
