package com.nomensvyat.github.archtest.core.di

import com.nomensvyat.github.archtest.core.SharedStateHolder

interface SharedStateHolderProvider {
    fun provideSharedStateHolder(): SharedStateHolder
}