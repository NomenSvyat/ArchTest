package com.nomensvyat.github.ui.base.routing

import dagger.Reusable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@Reusable
class ExtendedRouter @Inject constructor(
    private val navigationScreenFactory: NavigationScreenFactory
) : Router() {

    fun navigateTo(screenName: String) {
        val screen = navigationScreenFactory.createScreen(screenName)
        navigateTo(screen)
    }
}