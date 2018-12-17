package com.nomensvyat.github.archtest.secondary

import android.os.Bundle
import com.nomensvyat.github.archtest.core.SharedStateHolder
import com.nomensvyat.github.archtest.core.di.ComponentManager
import com.nomensvyat.github.archtest.core.di.SharedStateHolderProvider
import com.nomensvyat.github.archtest.secondary.di.DaggerFeatureSecondaryComponent
import com.nomensvyat.github.ui.base.di.RoutingProvider
import com.nomensvyat.github.ui.base.presentation.BaseActivity
import javax.inject.Inject

class FeatureSecondaryActivity : BaseActivity() {

    @Inject
    lateinit var secondStateHolder: SharedStateHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
    }

    private fun inject() {
        val routingProvider = ComponentManager.INSTANCE.getOrThrow(RoutingProvider::class)
        val sharedStateHolderProvider = ComponentManager.INSTANCE.getOrThrow(SharedStateHolderProvider::class)
        DaggerFeatureSecondaryComponent.builder()
            .routingProvider(routingProvider)
            .sharedStateHolderProvider(sharedStateHolderProvider)
            .build()
            .injectTo(this)
    }
}
