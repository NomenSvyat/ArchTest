package com.nomensvyat.github.archtest.di

import android.app.Application
import com.nomensvyat.github.archtest.core.di.ComponentManager
import com.nomensvyat.github.archtest.di.application.ApplicationComponent
import com.nomensvyat.github.archtest.di.application.ApplicationModule
import com.nomensvyat.github.archtest.di.application.DaggerApplicationComponent
import kotlin.properties.Delegates

object AppComponentManager : ComponentManager() {

    var applicationComponent: ApplicationComponent by Delegates.notNull()
        private set

    fun init(application: Application) {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
        put(applicationComponent)
        ComponentManager.INSTANCE = this
    }
}
