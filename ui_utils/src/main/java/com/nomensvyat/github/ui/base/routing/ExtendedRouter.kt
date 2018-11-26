package com.nomensvyat.github.ui.base.routing

import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ExtendedRouter @Inject constructor(
    private val navigationScreenFactory: NavigationScreenFactory
) : Router() {

    fun navigateTo(screenName: String) {
        val screen = navigationScreenFactory.createScreen(screenName)
        navigateTo(screen)
    }
}