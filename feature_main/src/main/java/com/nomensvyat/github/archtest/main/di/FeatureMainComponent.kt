package com.nomensvyat.github.archtest.main.di

import com.nomensvyat.github.archtest.core.di.PerParentFeature
import com.nomensvyat.github.archtest.core.di.SharedStateHolderProvider
import com.nomensvyat.github.archtest.main.FeatureMainActivity
import com.nomensvyat.github.ui.base.di.RoutingProvider
import dagger.Component

@PerParentFeature
@Component(
    dependencies = [RoutingProvider::class],
    modules = [FeatureMainModule::class]
)
interface FeatureMainComponent : SharedStateHolderProvider {
    fun injectTo(target: FeatureMainActivity)
}