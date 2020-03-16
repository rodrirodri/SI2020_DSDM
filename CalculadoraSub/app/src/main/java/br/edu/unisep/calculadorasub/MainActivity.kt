package br.edu.unisep.calculadorasub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
    }

    private fun setupEvents() {
        buttonSubG1.setOnClickListener {
            calculateSub(1)
        }

        buttonSubG2.setOnClickListener {
            calculateSub(2)
        }

        buttonClear.setOnClickListener {
            clear()
        }
    }

    private fun calculateSub(option: Int) {
        val gradeKeep = editTextGradeKeep.text.toString().toDouble()

        val gradeSub = if (option == 1) {
            (21 - 2 * gradeKeep)
        } else {
            (21 - gradeKeep) / 2
        }

        val df = DecimalFormat("#0.0")
        textViewResult.text = df.format(gradeSub)

        groupResult.visibility = View.VISIBLE
    }

    private fun clear() {
        groupResult.visibility = View.INVISIBLE
        editTextGradeKeep.text.clear()
        editTextGradeKeep.requestFocus()
    }

}
