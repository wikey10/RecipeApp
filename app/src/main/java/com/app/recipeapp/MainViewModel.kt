package com.app.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel :ViewModel() {


    private val _categoryState = mutableStateOf(RecipeState())

    val categoriesState : State<RecipeState> = _categoryState


    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    list = response.categories,
                    error = null
                )
                println("data loaded")
            }
            catch (e:Exception){
                println("Exception $e")
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading:Boolean =true,
        val list: List<Category> = emptyList(),
        val error: String? =null
    )

}