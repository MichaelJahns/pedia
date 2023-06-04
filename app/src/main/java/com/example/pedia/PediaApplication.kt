package com.example.pedia

import android.app.Application
import com.example.pedia.di.appModule
import org.koin.core.context.startKoin

class PediaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(listOf(appModule,))
        }
    }
}