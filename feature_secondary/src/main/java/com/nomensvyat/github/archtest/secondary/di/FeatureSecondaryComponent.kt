package com.nomensvyat.github.archtest.secondary.di

import com.nomensvyat.github.archtest.secondary.FeatureSecondaryActivity
import dagger.Subcomponent

@Subcomponent
interface FeatureSecondaryComponent {
    fun injectTo(target: FeatureSecondaryActivity)
}