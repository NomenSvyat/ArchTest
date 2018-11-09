package com.nomensvyat.github.archtest.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nomensvyat.github.archtest.core.di.ComponentManager
import com.nomensvyat.github.archtest.main.di.FeatureMainComponent
import com.nomensvyat.github.archtest.main.di.FeatureMainComponentProvider

class FeatureMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_main)
    }

    private fun inject() {
        val componentManager = ComponentManager.INSTANCE
        componentManager.getOrThrow(FeatureMainComponentProvider::class)
            .provideFeatureMainComponent()
            .also { componentManager.put(it) }
            .injectTo(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            ComponentManager.INSTANCE.remove(FeatureMainComponent::class)
        }
    }
}
