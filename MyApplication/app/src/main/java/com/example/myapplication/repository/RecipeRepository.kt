package com.example.myapplication.repository

import android.content.Context
import android.util.Log
import com.example.myapplication.repository.toRecipeModelList
import com.example.myapplication.repository.RecipesDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.java.canonicalName
    private var recipesList: List<RecipeModel> = emptyList()

    fun getRecipes(context: Context) : List<RecipeModel> {
        lateinit var jsonString: String

        try{
            jsonString =
                context.assets.open("all_recipes.json")
                    .bufferedReader()
                    .use {
                        it.readText()
                    }
        } catch (ioException: IOException) {
            Log.e(TAG,"Error occurred while reading JSON file: $ioException")
        }

        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)

        recipesList = recipesResponse.results.toRecipeModelList()
        return recipesList

    }

    /**
     * Returns a recipe based on the given ID.
     */

    fun getRecipe(recipeId: Int): RecipeModel? {
        return recipesList.find{it.id == recipeId}
    }
}