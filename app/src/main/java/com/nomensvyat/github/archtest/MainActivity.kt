package com.nomensvyat.github.archtest

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nomensvyat.github.archtest.core.di.getOrThrow
import com.nomensvyat.github.archtest.databinding.ActivityMainBinding
import com.nomensvyat.github.archtest.di.application.ApplicationComponent
import com.nomensvyat.github.ui.base.presentation.BaseActivity
import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import com.nomensvyat.github.ui.base.routing.Screens
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var router: ExtendedRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        componentManager.getOrThrow<ApplicationComponent>()
            .injectTo(this)

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        binding.btnMain.setOnClickListener {
            router.navigateTo(Screens.FEATURE_MAIN)
        }

    }
}
