package com.nomensvyat.github.archtest.main

import android.os.Bundle
import com.nomensvyat.github.archtest.main.di.DaggerFeatureMainComponent
import com.nomensvyat.github.archtest.main.di.FeatureMainComponent
import com.nomensvyat.github.ui.base.di.RoutingProvider
import com.nomensvyat.github.ui.base.presentation.BaseActivity
import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import com.nomensvyat.github.ui.base.routing.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class FeatureMainActivity : BaseActivity() {

    @Inject
    lateinit var router: ExtendedRouter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private fun inject() {
        val routingProvider = componentManager.getOrThrow(RoutingProvider::class)
        val featureMainComponent = DaggerFeatureMainComponent.builder()
            .routingProvider(routingProvider)
            .build()

        featureMainComponent
            .also { componentManager.put(it) }
            .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_main)

        router.navigateTo(Screens.FEATURE_SECONDARY)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(SupportAppNavigator(this, 0))
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            componentManager.remove(FeatureMainComponent::class)
        }
    }
}
