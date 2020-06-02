package br.edu.unisep.covidreport.ui.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.covidreport.R
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.helper.PreferencesHelper
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(private val onItemClick: (CountryDto) -> Unit) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var countries: List<CountryDto> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(
            itemView
        )
    }

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.itemView.textViewCountry.text = country.name
        holder.itemView.setOnClickListener { onItemClick(country) }

        val prefsHelper = PreferencesHelper.getInstance(holder.itemView.context)
        val favoriteCountry = prefsHelper.getCountry()

        holder.itemView.imageViewFavorite.isSelected = (favoriteCountry == country.name)

        holder.itemView.imageViewFavorite.setOnClickListener { icon ->

            if (icon.isSelected) {
                prefsHelper.clearCountry()
            } else {
                prefsHelper.saveCountry(country.name)
            }

            icon.isSelected = !icon.isSelected
            notifyDataSetChanged()
        }
    }

    fun setCountries(countries: List<CountryDto>) {
        this.countries = countries
        notifyDataSetChanged()
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}