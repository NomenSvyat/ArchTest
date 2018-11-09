package com.nomensvyat.github.archtest.main.di

import com.nomensvyat.github.archtest.core.SecondaryStateHolder
import com.nomensvyat.github.archtest.core.SharedStateHolder
import com.nomensvyat.github.archtest.core.di.PerParentFeature
import com.nomensvyat.github.archtest.main.SharedStateHolderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureMainModule {

    @PerParentFeature
    @Binds
    abstract fun provideSharedStateHolder(staStateHolderImpl: SharedStateHolderImpl): SharedStateHolder

    @PerParentFeature
    @Binds
    abstract fun provideSecondaryStateHolder(sharedStateHolder: SharedStateHolder): SecondaryStateHolder
}