package br.edu.unisep.covidreport.helper

import android.content.Context

class PreferencesHelper(private val context: Context) {

    private val prefs = context.getSharedPreferences("covid-preferences", Context.MODE_PRIVATE)

    fun saveCountry(country: String) {
        prefs.edit().putString("country", country).apply()
    }

    fun getCountry() = prefs.getString("country", null)

    fun clearCountry() {
        prefs.edit().remove("country").apply()
    }

    companion object {

        private var instance: PreferencesHelper? = null

        fun getInstance(context: Context): PreferencesHelper {
            if (instance == null) {
                instance = PreferencesHelper(context)
            }

            return instance!!
        }
    }
}