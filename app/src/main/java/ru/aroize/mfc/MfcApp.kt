package ru.aroize.mfc

import android.app.Application
import ru.aroize.mfc.di.AppComponent
import ru.aroize.mfc.di.DaggerAppComponent

class MfcApp: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}