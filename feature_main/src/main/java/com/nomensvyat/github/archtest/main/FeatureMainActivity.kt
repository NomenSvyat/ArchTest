package com.nomensvyat.github.archtest.main

import android.os.Bundle
import com.nomensvyat.github.archtest.main.di.DaggerFeatureMainComponent
import com.nomensvyat.github.archtest.main.di.FeatureMainComponent
import com.nomensvyat.github.ui.base.di.RoutingProvider
import com.nomensvyat.github.ui.base.presentation.BaseActivity
import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import com.nomensvyat.github.ui.base.routing.Screens
import javax.inject.Inject

class FeatureMainActivity : BaseActivity() {

    @Inject
    lateinit var router: ExtendedRouter

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

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            componentManager.remove(FeatureMainComponent::class)
        }
    }
}
