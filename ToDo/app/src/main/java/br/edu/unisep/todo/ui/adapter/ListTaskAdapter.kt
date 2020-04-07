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
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(task: TaskDto) {
            itemView.textViewTaskTitle.text = task.title

            if (task.priority == 1) {
                itemView.iconPriority.imageTintList = ColorStateList.valueOf(itemView.context.getColor(R.color.colorPriorityLow))
            } else if (task.priority == 2) {
                itemView.iconPriority.imageTintList = ColorStateList.valueOf(itemView.context.getColor(R.color.colorPriorityMedium))
            } else {
                itemView.iconPriority.imageTintList = ColorStateList.valueOf(itemView.context.getColor(R.color.colorPriorityHigh))
            }
        }
    }

}