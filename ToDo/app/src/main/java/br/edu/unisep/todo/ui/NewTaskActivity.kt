package br.edu.unisep.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.unisep.todo.R
import br.edu.unisep.todo.domain.dto.NewTaskDto
import br.edu.unisep.todo.ui.viewmodel.NewTaskViewModel
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTaskActivity : AppCompatActivity() {

    private val viewModel: NewTaskViewModel by lazy {
        ViewModelProvider(this).get(NewTaskViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)

        buttonSave.setOnClickListener { saveTask() }

        viewModel.saveTaskResult.observe(this, Observer { onSaveResult() })
    }

    private fun saveTask() {
        val priority = when (radioGroupPriority.checkedRadioButtonId) {
            R.id.radioPriorityLow -> 1
            R.id.radioPriorityMedium -> 2
            else -> 3
        }

        val newTask = NewTaskDto(
            editTextTitle.text.toString(),
            editTextDescription.text.toString(),
            priority
        )

        viewModel.save(newTask)
    }

    private fun onSaveResult() {
        setResult(RESULT_OK)
        finish()
    }
}
