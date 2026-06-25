package com.pdm0126.labo6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.labo6.data.model.Meals
import com.pdm0126.labo6.data.repository.MealsRepository
import com.pdm0126.labo6.data.repository.MealsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealsViewModel(
    private val repository: MealsRepository = MealsRepositoryImpl()
) : ViewModel() {

    private val _meals = MutableStateFlow<List<Meals>>(emptyList())
    val meals: StateFlow<List<Meals>> = _meals.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadMeals() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getMeals()
                .onSuccess { _meals.value = it }
                .onFailure { it.printStackTrace() }
            _isLoading.value = false
        }
    }
}