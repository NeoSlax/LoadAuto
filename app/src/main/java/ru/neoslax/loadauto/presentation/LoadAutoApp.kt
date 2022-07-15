package ru.neoslax.loadauto.presentation

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import ru.neoslax.loadauto.di.DaggerApplicationComponent

class LoadAutoApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        MapKitFactory.setApiKey("9572b31f-0eea-486f-bde5-9f8232ab2a04")
        super.onCreate()
    }
}