package br.edu.unisep.myweather.ui.map

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.unisep.myweather.R

class MapsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
    }


    companion object {
        fun getIntent(context: Context) = Intent(context, MapsActivity::class.java)
    }
}
