package com.example.uas_todolistproject

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TaskItemRepository(private val taskItemDao: TaskItemDao)
{
    //menghasilkan daftar semua item tugas
    val allTaskItems: Flow<List<TaskItem>> = taskItemDao.allTaskItems()

    //memasukkan (insert) suatu item tugas (TaskItem) ke dalam database.
    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItem)
    {
        taskItemDao.insertTaskItem(taskItem)
    }

//    Memperbarui (update) suatu item tugas (TaskItem) dalam database
    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItem)
    {
        taskItemDao.updateTaskItem(taskItem)
    }
}