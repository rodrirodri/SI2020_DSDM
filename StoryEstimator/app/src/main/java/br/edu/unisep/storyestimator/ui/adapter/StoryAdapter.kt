package br.edu.unisep.storyestimator.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.storyestimator.dto.StoryDto
import br.edu.unisep.storyestimator.model.entity.Story

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    private var stories = listOf<StoryDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun updateItems(items: List<StoryDto>) {

    }

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(story: StoryDto) {

        }
    }
}