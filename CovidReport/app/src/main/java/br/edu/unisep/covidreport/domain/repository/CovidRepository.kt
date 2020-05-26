package br.edu.unisep.covidreport.domain.repository

import br.edu.unisep.covidreport.data.service.factory.CovidServiceFactory
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.domain.dto.TotalDto

class CovidRepository {

    private val covidService = CovidServiceFactory.getCovidService()

    suspend fun getTotals(): ApiResult<TotalDto> {
        return try {
            val response = covidService.getTotals()
            val totalResponse = response.first()

            ApiResult.Success(
                TotalDto(
                    totalResponse.confirmed,
                    totalResponse.recovered,
                    totalResponse.critical,
                    totalResponse.deaths
                )
            )
        } catch (e: Exception) {
            ApiResult.Error()
        }
    }

    suspend fun getCountries(): ApiResult<List<CountryDto>> {
        return try {
            val response = covidService.listCountries()

            ApiResult.Success(response.map { country ->
                CountryDto(country.name, country.alpha2code)
            })
        } catch (e: Exception) {
            ApiResult.Error()
        }
    }

    suspend fun getTotalsByCountry(country: CountryDto): ApiResult<TotalDto> {

    }


}