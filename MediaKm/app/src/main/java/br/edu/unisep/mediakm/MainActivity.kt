package br.edu.unisep.mediakm

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
        buttonCalculate.setOnClickListener { calculate() }
        buttonClear.setOnClickListener { clear() }
    }

    private fun calculate() {
        val previousKm = editTextPreviousKm.text.toString().toDouble()
        val currentKm = editTextCurrentKm.text.toString().toDouble()
        val fuelAmount = editTextFuelAmount.text.toString().toDouble()

        val average = (currentKm - previousKm) / (50 - fuelAmount)

        val df = DecimalFormat("#,#0")
        textViewResult.text = df.format(average)

        groupResult.visibility = View.VISIBLE
    }

    private fun clear() {
        editTextPreviousKm.text.clear()
        editTextCurrentKm.text.clear()
        editTextFuelAmount.text.clear()

        editTextPreviousKm.requestFocus()

        groupResult.visibility = View.INVISIBLE
    }

}
