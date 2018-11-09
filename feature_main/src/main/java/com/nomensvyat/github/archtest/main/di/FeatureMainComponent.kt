package com.nomensvyat.github.archtest.main.di

import com.nomensvyat.github.archtest.main.FeatureMainActivity
import dagger.Subcomponent

@Subcomponent
interface FeatureMainComponent {
    fun injectTo(target: FeatureMainActivity)
}