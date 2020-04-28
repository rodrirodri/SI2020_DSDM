package br.edu.unisep.covidreport.data.service.factory

import br.edu.unisep.covidreport.data.service.CovidService
import br.edu.unisep.covidreport.data.service.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CovidServiceFactory {

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getCovidService() = retrofit.create(CovidService::class.java)
}