package com.nomensvyat.github.archtest.di.application

import com.nomensvyat.github.archtest.MainActivity
import com.nomensvyat.github.ui.base.di.NavigationModule
import com.nomensvyat.github.ui.base.di.RoutingProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NavigationModule::class
    ]
)
interface ApplicationComponent : RoutingProvider {
    fun injectTo(target: MainActivity)
}