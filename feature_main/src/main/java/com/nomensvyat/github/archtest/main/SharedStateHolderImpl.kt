package com.nomensvyat.github.archtest.main

import com.nomensvyat.github.archtest.core.SharedStateHolder
import com.nomensvyat.github.archtest.core.di.PerParentFeature
import javax.inject.Inject

@PerParentFeature
class SharedStateHolderImpl @Inject constructor() : SharedStateHolder {
    override var secondaryState: String? = null
}