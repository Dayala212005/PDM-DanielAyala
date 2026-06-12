package com.pdm0126.labo4.data.repositorie.taskRespository

import com.pdm0126.labo4.data.database.dao.TaskDao
import com.pdm0126.labo4.data.toEntity
import com.pdm0126.labo4.data.toTask
import com.pdm0126.labo4.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskDatabaseRepository(private val taskDao: TaskDao) : ITaskRepository {


    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { list -> list.map { it.toTask() } }
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task.toEntity())
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task.toEntity())
    }
}