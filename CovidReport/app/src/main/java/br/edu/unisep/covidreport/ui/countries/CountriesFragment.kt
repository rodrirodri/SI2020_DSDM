package br.edu.unisep.covidreport.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.covidreport.R
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.ui.countries.adapter.CountryAdapter
import kotlinx.android.synthetic.main.fragment_countries.*

class CountriesFragment : Fragment() {

    private lateinit var adapter: CountryAdapter
    private val countriesViewModel: CountriesViewModel by lazy {
        ViewModelProvider(this).get(CountriesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_countries, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()

        countriesViewModel.countries.observe(viewLifecycleOwner, Observer { result ->
            if (result is ApiResult.Success) {
                adapter.setCountries(result.result)
            }
        })

        countriesViewModel.getCountries()
    }

    private fun setupList() {
        adapter = CountryAdapter(this::showCountryTotals)

        listCountries.adapter = adapter
        listCountries.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false
        )
        listCountries.addItemDecoration(
            DividerItemDecoration(
                context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun showCountryTotals(country: CountryDto) {
        CountryDetailsDialog(country).show(parentFragmentManager, null)
    }

}
