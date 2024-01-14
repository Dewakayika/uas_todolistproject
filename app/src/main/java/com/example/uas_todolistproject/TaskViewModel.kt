package com.example.uas_todolistproject

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.time.LocalDate

class TaskViewModel(private val repository: TaskItemRepository): ViewModel()
{
//    menyimpan daftar semua item tugas.  ini akan memungkinkan UI (Activity atau Fragment) untuk mengamati perubahan data secara langsung.
    val taskItems: LiveData<List<TaskItem>> = repository.allTaskItems.asLiveData()

//memasukkan (insert) suatu item tugas ke dalam database melalui objek TaskItemRepository.
    fun addTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.insertTaskItem(taskItem)
    }

//    Metode ini menggunakan coroutine untuk memperbarui (update) suatu item tugas
    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

//    menandai suatu item tugas sebagai selesai
    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        if (!taskItem.isCompleted())
            taskItem.completedDateString = TaskItem.dateFormatter.format(LocalDate.now())
        repository.updateTaskItem(taskItem)
    }
}

class TaskItemModelFactory(private val repository: TaskItemRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}