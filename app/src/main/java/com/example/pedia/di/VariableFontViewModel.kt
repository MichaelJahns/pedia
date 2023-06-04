package com.example.pedia.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VariableFontViewModel : ViewModel() {
    private val _weight = MutableLiveData cx(0)
    val weight: LiveData<Int> = _weight

    fun setWeight(weight: Int){
        _weight.value = weight
    }
}