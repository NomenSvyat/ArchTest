package com.nomensvyat.github.ui.base.di

import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideCicerone(extendedRouter: ExtendedRouter): Cicerone<ExtendedRouter> = Cicerone.create(extendedRouter)

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<ExtendedRouter>): Router = cicerone.router

    @Singleton
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<ExtendedRouter>): NavigatorHolder = cicerone.navigatorHolder
}