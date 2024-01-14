package com.example.uas_todolistproject

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_todolistproject.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

//holder (pemegang) untuk item tugas dalam RecyclerView
class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root)
{
//    Properti ini menyimpan objek DateTimeFormatter yang digunakan untuk memformat waktu dalam tampilan item.
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(taskItem: TaskItem)
    {
        //  Pengaturan teks nama
        binding.name.text = taskItem.name

        // Mengatur strikethrough text jika tugas sudah selesai
        if (taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        // Mengatur ikon dan warna untuk tombol complete
        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        // Menangani klik pada tombol complete
        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }

        // Menangani klik pada seluruh item untuk mengedit
        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }

        // Mengatur teks waktu jika ada tenggat waktu, jika tidak kosongkan
        if(taskItem.dueTime() != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime())
        else
            binding.dueTime.text = ""
    }
}