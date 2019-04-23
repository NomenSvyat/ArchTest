package com.nomensvyat.github.archtest.secondary

import android.os.Bundle
import com.nomensvyat.github.archtest.core.SharedStateHolder
import com.nomensvyat.github.archtest.secondary.di.FeatureSecondaryComponentProvider
import com.nomensvyat.github.ui.base.presentation.BaseActivity
import javax.inject.Inject

class FeatureSecondaryActivity : BaseActivity() {

    @Inject
    lateinit var seconStateHolder: SharedStateHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
    }

    private fun inject() {
        componentManager.getOrThrow(FeatureSecondaryComponentProvider::class)
            .provideFeatureSecondaryComponent()
            .injectTo(this)
    }
}
