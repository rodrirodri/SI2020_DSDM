package br.edu.unisep.covidreport.data.service

import br.edu.unisep.covidreport.data.remote.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface CovidService {

    @GET(SERVICE_GET_LIST_COUNTRIES)
    suspend fun listCountries(@Header(HEADER_RAPID_API_HOST) host: String,
                              @Header(HEADER_RAPID_API_KEY) apiKey: String): List<CountryResponse>

}