package com.example.mad_practical_1

import android.app.Application
import timber.log.Timber

class DiceRoller : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}