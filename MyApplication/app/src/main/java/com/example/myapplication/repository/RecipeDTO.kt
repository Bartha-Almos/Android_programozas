package com.example.myapplication.repository

import com.example.myapplication.repository.toModel
import com.example.myapplication.repository.toRecipeModelList

/**
 *
 */

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String? = "Default description",
    val aspect_ratio: String,
    val user_ratings: UserRatingsDTO,
    val thumbnail_url: String,
    val total_time_tier: TotalTimeDTO,
    val instructions: List<InstructionDTO>

)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name,
        description = this.description,
        aspect_ratio = this.aspect_ratio,
        thumbnailUrl = this.thumbnail_url,
        userRatings = this.user_ratings.toModel(),
        total_time_tier = this.total_time_tier.toModel(),
        instructions = this.instructions.toModelList()
    )
}
fun List<RecipeDTO>.toRecipeModelList(): List<RecipeModel> {
    return this.map { it.toModel() }
}