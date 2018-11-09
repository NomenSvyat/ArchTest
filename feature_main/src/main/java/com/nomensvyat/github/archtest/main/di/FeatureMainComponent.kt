package com.nomensvyat.github.archtest.main.di

import com.nomensvyat.github.archtest.core.di.PerParentFeature
import com.nomensvyat.github.archtest.main.FeatureMainActivity
import com.nomensvyat.github.archtest.secondary.di.FeatureSecondaryComponentProvider
import dagger.Subcomponent

@PerParentFeature
@Subcomponent(modules = [FeatureMainModule::class])
interface FeatureMainComponent : FeatureSecondaryComponentProvider {
    fun injectTo(target: FeatureMainActivity)
}