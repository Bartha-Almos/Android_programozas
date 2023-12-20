package com.example.myapplication.repository

data class TotalTimeDTO(
    val tier: String? = "0",
    val display_tier: String? = "0"
)

fun TotalTimeDTO.toModel(): TotalTimeModel {
    return TotalTimeModel(
        tier = this.tier,
        display_tier = this.display_tier
    )
}