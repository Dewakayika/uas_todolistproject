package com.example.uas_todolistproject

interface TaskItemClickListener
{
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}