package com.example.pedia.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val capital: String,
    val code: String,
    val currency: Currency,
    val demonym: String?,
    val flag: String,
    val language: Language,
    val name: String,
    val region: String
) : Parcelable
