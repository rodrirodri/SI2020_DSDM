package br.edu.unisep.myexpenses.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.myexpenses.R
import br.edu.unisep.myexpenses.dto.ExpenseDto
import kotlinx.android.synthetic.main.item_expense.view.*
import java.text.DecimalFormat
import java.util.*

class ExpenseAdapter : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private var listExpenses = listOf<ExpenseDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)

        return ExpenseViewHolder(itemView)
    }

    override fun getItemCount() = listExpenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bindItem(listExpenses[position])
    }

    fun updateItems(items: List<ExpenseDto>) {
        this.listExpenses = items
        notifyDataSetChanged()
    }

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(expense: ExpenseDto) {
            itemView.textViewDescription.text = expense.description
            itemView.textViewDate.text = expense.date

            val formatter = DecimalFormat.getCurrencyInstance(Locale("pt", "BR"))
            itemView.textViewValue.text = formatter.format(expense.value)
        }
    }
}