package com.example.myapplication.repository

data class UserRatingsDTO(
    val count_positive: Int,
    val score: Float,
    val count_negative: Int
)

fun UserRatingsDTO.toModel(): UserRatingsModel {
    return UserRatingsModel(
        score = this.score * 10
    )
}