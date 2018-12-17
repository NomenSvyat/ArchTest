package com.nomensvyat.github.archtest.secondary.di

import com.nomensvyat.github.archtest.core.di.SharedStateHolderProvider
import com.nomensvyat.github.archtest.secondary.FeatureSecondaryActivity
import com.nomensvyat.github.ui.base.di.RoutingProvider
import dagger.Component

@Component(dependencies = [RoutingProvider::class, SharedStateHolderProvider::class])
interface FeatureSecondaryComponent {
    fun injectTo(target: FeatureSecondaryActivity)
}