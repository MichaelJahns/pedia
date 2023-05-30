package com.example.pedia.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    val code: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
) : Parcelable