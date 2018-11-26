package com.nomensvyat.github.ui.base.routing

import ru.terrakok.cicerone.Screen

interface NavigationScreenFactory {
    fun createScreen(screenName: String): Screen
}