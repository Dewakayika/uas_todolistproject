package com.example.uas_todolistproject

interface TaskItemClickListener
{
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}
//Interface TaskItemClickListener ini bertujuan untuk memberikan
// fleksibilitas dalam menangani peristiwa-peristiwa yang terkait
// dengan item tugas dalam aplikasi to-do list.