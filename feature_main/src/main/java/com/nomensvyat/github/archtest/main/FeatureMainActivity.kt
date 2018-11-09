package com.nomensvyat.github.archtest.main

import android.os.Bundle
import com.nomensvyat.github.archtest.main.di.FeatureMainComponent
import com.nomensvyat.github.archtest.main.di.FeatureMainComponentProvider
import com.nomensvyat.github.ui.base.presentation.BaseActivity

class FeatureMainActivity : BaseActivity() {
    private fun inject() {
        componentManager.getOrThrow(FeatureMainComponentProvider::class)
            .provideFeatureMainComponent()
            .also { componentManager.put(it) }
            .injectTo(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            componentManager.remove(FeatureMainComponent::class)
        }
    }
}
