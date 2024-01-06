package com.example.uas_todolistproject

import android.app.Application

class TodoApplication : Application()
{
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}