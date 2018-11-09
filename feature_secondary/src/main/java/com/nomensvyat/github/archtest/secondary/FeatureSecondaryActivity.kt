package com.nomensvyat.github.archtest.secondary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nomensvyat.github.archtest.core.di.ComponentManager
import com.nomensvyat.github.archtest.secondary.di.FeatureSecondaryComponentProvider

class FeatureSecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
    }

    private fun inject() {
        ComponentManager.INSTANCE.getOrThrow(FeatureSecondaryComponentProvider::class)
            .provideFeatureSecondaryComponent()
            .injectTo(this)
    }
}
