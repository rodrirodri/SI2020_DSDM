package br.edu.unisep.todo.ui.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.unisep.todo.R
import br.edu.unisep.todo.domain.dto.TaskDto
import kotlinx.android.synthetic.main.item_task.view.*

class ListTaskAdapter : RecyclerView.Adapter<ListTaskAdapter.TaskViewHolder>() {

    private var tasks = listOf<TaskDto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindItem(tasks[position])
    }

    fun updateItems(items: List<TaskDto>){
        this.tasks = items
        notifyDataSetChanged()
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(task: TaskDto) {

            with(itemView) {

                textViewTaskTitle.text = task.title

                val color = when (task.priority) {
                    1 -> R.color.colorPriorityLow
                    2 -> R.color.colorPriorityMedium
                    else -> R.color.colorPriorityHigh
                }

                iconPriority.imageTintList = ColorStateList.valueOf(context.getColor(color))
            }
        }
    }
}