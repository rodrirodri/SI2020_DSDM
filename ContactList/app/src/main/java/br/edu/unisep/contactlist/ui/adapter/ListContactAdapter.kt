package br.edu.unisep.contactlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.contactlist.R
import br.edu.unisep.contactlist.domain.dto.ContactDto
import kotlinx.android.synthetic.main.item_contact.view.*

class ListContactAdapter : RecyclerView.Adapter<ListContactAdapter.ContactViewHolder>(){

    private var contacts = listOf<ContactDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_contact, parent, false)

        return ContactViewHolder(itemView)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    fun updateContacts(items: List<ContactDto>) {
        contacts = items
        notifyDataSetChanged()
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(contact: ContactDto) {
            itemView.textViewName.text = contact.name
            itemView.textViewEmail.text = contact.email
        }
    }
}
