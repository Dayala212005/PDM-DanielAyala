package com.pdm0126.labo6.data.repository

import com.pdm0126.labo6.data.model.Meals

interface MealsRepository {
    suspend fun getMeals(): Result<List<Meals>>
}