package com.example.uas_todolistproject

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskItemDao
{
//    @Query annotation digunakan untuk menentukan query SQL untuk mengambil semua
//    item dari tabel task_item_table dan mengurutkannya berdasarkan kolom id
//    secara ascending.
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    fun allTaskItems(): Flow<List<TaskItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem: TaskItem)

    @Update
    suspend fun updateTaskItem(taskItem: TaskItem)

    @Delete
    suspend fun deleteTaskItem(taskItem: TaskItem)
}