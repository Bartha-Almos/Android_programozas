package com.example.myapplication.repository

data class InstructionDTO(
    val id: Int,
    val position: Int,
    val display_text: String,
    val start_time: Int,
    val end_time: Int,
    val appliance: String?,
    val temperature: Int?
)

fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.id,
        position = this.position,
        display_text = this.display_text,
        start_time = this.start_time,
        end_time = this.end_time,
        appliance = this.appliance ?: "",
        temperature = this.temperature
    )
}


fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
    return this.map { it.toModel() }
}