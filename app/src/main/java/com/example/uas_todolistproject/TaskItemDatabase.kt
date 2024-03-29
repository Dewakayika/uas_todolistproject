package com.example.uas_todolistproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//implementasi Room Database dalam Android
@Database(entities = [TaskItem::class], version = 1, exportSchema = false)
public abstract class TaskItemDatabase : RoomDatabase()
{
    abstract fun taskItemDao(): TaskItemDao

    companion object
    {
        @Volatile
        private var INSTANCE: TaskItemDatabase? = null

//blok sinkronisasi (synchronized) untuk menghindari pembuatan beberapa instance dalam waktu yang bersamaan
        fun getDatabase(context: Context): TaskItemDatabase
        {
            return INSTANCE ?: synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskItemDatabase::class.java,
                        "task_item_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
        }
    }
}