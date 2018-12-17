package com.nomensvyat.github.ui.base.di

import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface RoutingProvider {
    fun provideRouter(): Router
    fun provideExtendedRouter(): ExtendedRouter
    fun provideNavigatorHolder(): NavigatorHolder
}