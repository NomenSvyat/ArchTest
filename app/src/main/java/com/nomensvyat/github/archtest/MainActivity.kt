package com.nomensvyat.github.archtest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nomensvyat.github.archtest.core.di.ComponentManager
import com.nomensvyat.github.archtest.databinding.ActivityMainBinding
import com.nomensvyat.github.archtest.di.application.ApplicationComponent
import com.nomensvyat.github.ui.base.routing.ExtendedRouter
import com.nomensvyat.github.ui.base.routing.Screens
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: ExtendedRouter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.INSTANCE.getOrThrow(ApplicationComponent::class)
            .injectTo(this)

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        binding.btnMain.setOnClickListener {
            router.navigateTo(Screens.FEATURE_MAIN)
        }

    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(SupportAppNavigator(this, 0))
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
