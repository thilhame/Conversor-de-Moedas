package com.example.conversodedinheiro

import android.app.Application
import com.example.conversodedinheiro.data.di.DataModules
import com.example.conversodedinheiro.domain.di.DomainModule
import com.example.conversodedinheiro.presentation.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)



            DataModules.load()
            DomainModule.load()
            PresentationModule.load()

        }
    }
}

