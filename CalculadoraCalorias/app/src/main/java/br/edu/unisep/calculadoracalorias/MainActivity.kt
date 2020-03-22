package br.edu.unisep.calculadoracalorias

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private var weight: Double = 0.0
    private var height: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        buttonCalculate.setOnClickListener { calculate() }
    }

    private fun calculate() {
        weight = editTextWeight.text.toString().toDouble()
        height = editTextHeight.text.toString().toDouble()

        val weightCalories = if (calculateImc() > 24.9) {
            calculateMaxHeight()
        } else {
            weight
        }

        val result = weightCalories * getActivityLevel()

        val df = DecimalFormat("#,##0.0")
        textViewResult.text = df.format(result)

        groupResult.visibility = View.VISIBLE
    }

    private fun calculateImc() = weight / height.pow(2)

    private fun calculateMaxHeight() = height.pow(2) * 24.9

    private fun getActivityLevel() = when {
        radioButtonIntense.isChecked -> 20
        radioButtonModerate.isChecked -> 30
        else -> 40
    }
}
