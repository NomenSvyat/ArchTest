package com.nomensvyat.github.archtest.di.application

import com.nomensvyat.github.archtest.main.di.FeatureMainComponentProvider
import com.nomensvyat.github.ui.base.di.NavigationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NavigationModule::class
    ]
)
interface ApplicationComponent : FeatureMainComponentProvider