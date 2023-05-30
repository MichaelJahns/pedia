package com.example.pedia.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CountryList : ArrayList<Country>(), Parcelable