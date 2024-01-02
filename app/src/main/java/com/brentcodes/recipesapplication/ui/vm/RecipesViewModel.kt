package com.brentcodes.recipesapplication.ui.vm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brentcodes.recipesapplication.model.data.EdamamResponse
import com.brentcodes.recipesapplication.model.network.RecipeApi
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

sealed interface RecipesUiState {
    data class Success(val response : EdamamResponse) : RecipesUiState
    object Error : RecipesUiState
    object Loading : RecipesUiState
}

class RecipesViewModel : ViewModel() {
    var recipesUiState: RecipesUiState by mutableStateOf(RecipesUiState.Loading)
        private set

    init {
        getRecipes()
    }

    fun getRecipes() {
        viewModelScope.launch {
            recipesUiState = try {
                val listResult = RecipeApi.retrofitService.getResponse("public", "chicken")
                RecipesUiState.Success(
                    listResult
                )
            } catch(e: IOException) {
                Log.d("error", e.message!!)
                RecipesUiState.Error
            }
        }
    }
}