package com.example.uas_todolistproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_todolistproject.databinding.TaskItemCellBinding

class TaskItemAdapter(
//    taskItems: List dari objek TaskItem. Ini akan diikat ke RecyclerView
    private val taskItems: List<TaskItem>,
    private val clickListener: TaskItemClickListener
): RecyclerView.Adapter<TaskItemViewHolder>()
{

//    Metode ini dipanggil ketika RecyclerView memerlukan pembuat tampilan baru.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(from, parent, false)
        return TaskItemViewHolder(parent.context, binding, clickListener)
    }

//    Metode ini dipanggil untuk mengikat data pada posisi tertentu ke TaskItemViewHolder.
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }
// Metode ini mengembalikan jumlah item dalam daftar (taskItems).
    override fun getItemCount(): Int = taskItems.size
}