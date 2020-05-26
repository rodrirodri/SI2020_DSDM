package br.edu.unisep.covidreport.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.unisep.covidreport.R
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.dto.TotalDto
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.totals.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is ApiResult.Success -> onTotalsResult(result.result)
                is ApiResult.Error -> onTotalsError()
            }
        })

        refreshHome.setOnRefreshListener { this.getTotals() }

        getTotals()
    }

    private fun getTotals() {
        viewTotals.visibility = View.INVISIBLE
        progressBarTotals.visibility = View.VISIBLE
        textViewErrorTotals.visibility = View.GONE

        refreshHome.isRefreshing = false

        homeViewModel.getTotals()
    }

    private fun onTotalsResult(totals: TotalDto) {
        val formatter = NumberFormat.getInstance(Locale("pt", "BR"))

        textViewTotalCases.text = formatter.format(totals.confirmed)
        textViewCritical.text = formatter.format(totals.critical)
        textViewRecovered.text = formatter.format(totals.recovered)
        textViewDeaths.text = formatter.format(totals.deaths)

        viewTotals.visibility = View.VISIBLE
        progressBarTotals.visibility = View.GONE
    }

    private fun onTotalsError() {
        progressBarTotals.visibility = View.GONE
        textViewErrorTotals.visibility = View.VISIBLE
    }

}
