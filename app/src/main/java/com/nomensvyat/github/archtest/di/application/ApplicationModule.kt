package com.nomensvyat.github.archtest.di.application

import android.app.Application
import android.content.Context
import com.nomensvyat.github.archtest.routing.NavigationScreenFactoryImpl
import com.nomensvyat.github.ui.base.routing.NavigationScreenFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModule.BindsModule::class])
class ApplicationModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application


    @Module
    abstract class BindsModule {

        @Singleton
        @Binds
        abstract fun provideNavigationScreenFactory(navigationScreenFactoryImpl: NavigationScreenFactoryImpl): NavigationScreenFactory
    }
}