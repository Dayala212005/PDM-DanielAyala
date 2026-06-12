package com.pdm0126.labo4.data

import com.pdm0126.labo4.data.database.entities.TaskEntity
import com.pdm0126.labo4.model.Task
import java.util.Date

fun TaskEntity.toTask() = Task(
    id = id,
    title = title,
    description = description,
    endDate = Date(endDate),
    isCompleted = isCompleted
)

fun Task.toEntity() = TaskEntity(
    id = id,
    title = title,
    description = description,
    endDate = endDate.time,
    isCompleted = isCompleted
)