package com.nomensvyat.github.archtest.routing

import android.content.Context
import android.content.Intent
import com.nomensvyat.github.archtest.main.FeatureMainActivity
import com.nomensvyat.github.archtest.secondary.FeatureSecondaryActivity
import com.nomensvyat.github.ui.base.routing.NavigationScreenFactory
import com.nomensvyat.github.ui.base.routing.Screens
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class NavigationScreenFactoryImpl @Inject constructor() : NavigationScreenFactory {
    override fun createScreen(screenName: String): Screen {
        return when (screenName) {
            //Don't do like this in production
            Screens.FEATURE_MAIN -> object : SupportAppScreen() {
                override fun getActivityIntent(context: Context?): Intent {
                    return Intent(context, FeatureMainActivity::class.java)
                }
            }
            Screens.FEATURE_SECONDARY -> object : SupportAppScreen() {
                override fun getActivityIntent(context: Context?): Intent {
                    return Intent(context, FeatureSecondaryActivity::class.java)
                }
            }
            else -> throw IllegalArgumentException("No screen for '$screenName'")
        }
    }
}