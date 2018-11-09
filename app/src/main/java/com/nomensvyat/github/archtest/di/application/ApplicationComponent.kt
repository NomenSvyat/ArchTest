package com.nomensvyat.github.archtest.di.application

import com.nomensvyat.github.archtest.main.di.FeatureMainComponentProvider
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : FeatureMainComponentProvider