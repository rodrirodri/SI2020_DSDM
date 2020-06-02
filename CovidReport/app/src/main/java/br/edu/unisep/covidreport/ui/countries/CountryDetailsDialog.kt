package br.edu.unisep.covidreport.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.unisep.covidreport.R
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.CountryDto
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_country_detail.view.*
import java.text.NumberFormat
import java.util.*

class CountryDetailsDialog(private val country: CountryDto) : BottomSheetDialogFragment() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(CountryDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_country_detail, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.textViewCountry.text = country.name

        viewModel.countryTotals.observe(viewLifecycleOwner, Observer { totals ->
            if (totals is ApiResult.Success) {
                val formatter = NumberFormat.getInstance(Locale("pt", "BR"))

                view.textViewTotal.text = formatter.format(totals.result.confirmed)
                view.textViewCritical.text = formatter.format(totals.result.critical)
                view.textViewRecovered.text = formatter.format(totals.result.recovered)
                view.textViewDeaths.text = formatter.format(totals.result.deaths)
            }
        })

        viewModel.getCountryTotals(country)
    }
}