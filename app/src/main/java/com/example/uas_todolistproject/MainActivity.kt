package com.example.uas_todolistproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas_todolistproject.databinding.ActivityMainBinding

//Kelas MainActivity diwarisi dari
// AppCompatActivity dan mengimplementasikan antarmuka
// TaskItemClickListener.
class MainActivity : AppCompatActivity(), TaskItemClickListener
{
//    Variabel yang akan digunakan untuk mengakses elemen
//    antarmuka pengguna yang diikat menggunakan View Binding.
    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }

//    Metode ini dipanggil ketika aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

//    menghubungkan RecyclerView ke data dari ViewModel (taskViewModel)
    private fun setRecyclerView()
    {
        val mainActivity = this
        taskViewModel.taskItems.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }
//Metode editTaskItem membuka lembar tugas baru untuk mengedit
    override fun editTaskItem(taskItem: TaskItem)
    {
        NewTaskSheet(taskItem).show(supportFragmentManager,"newTaskTag")
    }
//menandai tugas sebagai selesai menggunakan ViewModel.
    override fun completeTaskItem(taskItem: TaskItem)
    {
        taskViewModel.setCompleted(taskItem)
    }
}







