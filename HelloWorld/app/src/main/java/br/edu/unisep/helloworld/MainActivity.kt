package br.edu.unisep.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend.setOnClickListener {
            send()
        }
    }

    private fun send() {
        val name = editTextName.text.toString()
        val message = "Olá, $name"

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
