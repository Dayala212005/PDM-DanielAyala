package com.pdm0126.labo6.data.repository

import com.pdm0126.labo6.data.api.KtorClient
import com.pdm0126.labo6.data.api.Users.MealsDto
import com.pdm0126.labo6.data.model.Meals
import io.ktor.client.call.body
import io.ktor.client.request.get
class MealsRepositoryImpl : MealsRepository {

    override suspend fun getMeals(): Result<List<Meals> {
        return try {
            val users = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<List<MealsDto>>()
                .map { it.toModel() }
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}