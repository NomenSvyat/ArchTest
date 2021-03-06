package com.nomensvyat.github.ui.base.presentation

import android.support.v7.app.AppCompatActivity
import com.nomensvyat.github.archtest.core.di.ComponentManager
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    protected inline val componentManager get() = ComponentManager.INSTANCE

    protected open val navigator: Navigator? by lazy { SupportAppNavigator(this, 0) }

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onResume() {
        super.onResume()
        navigator?.let { navigationHolder.setNavigator(it) }
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

}