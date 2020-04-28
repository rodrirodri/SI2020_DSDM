package br.edu.unisep.covidreport.data.service

import br.edu.unisep.covidreport.data.remote.CountryResponse
import br.edu.unisep.covidreport.data.remote.TotalResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface CovidService {

    @GET(SERVICE_GET_TOTALS)
    suspend fun getTotals(@Header(HEADER_RAPID_API_HOST) host: String = API_HOST,
                          @Header(HEADER_RAPID_API_KEY) apiKey: String = API_KEY): List<TotalResponse>

    @GET(SERVICE_GET_LIST_COUNTRIES)
    suspend fun listCountries(@Header(HEADER_RAPID_API_HOST) host: String = API_HOST,
                              @Header(HEADER_RAPID_API_KEY) apiKey: String = API_KEY): List<CountryResponse>

}