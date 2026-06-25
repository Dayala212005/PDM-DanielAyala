package com.pdm0126.labo6.data.api.Users

import com.pdm0126.labo6.data.model.Meals

data class MealsDto (
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)

fun MealsDto.toMedels(): Meals {
    return Meals(
        idMeal = idMeal,
        strMeal = strMeal,
        strCategory = strCategory,
        strArea = strArea,
        strMealThumb = strMealThumb
    )
}