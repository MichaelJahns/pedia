package com.example.pedia.view.fontdemos.custom

data class VariableFontModel(
    val name: String,
    val fontFamilyPath: String,
    val axes: List<String>,
    val minWeight: Int,
    val maxWeight: Int,
)