package com.nomensvyat.github.archtest

import android.app.Application
import com.nomensvyat.github.archtest.di.AppComponentManager

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponentManager.init(this)
    }
}