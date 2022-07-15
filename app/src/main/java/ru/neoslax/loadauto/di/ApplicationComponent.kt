package ru.neoslax.loadauto.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.neoslax.loadauto.presentation.LoadAutoApp
import ru.neoslax.loadauto.presentation.MainActivity

@Component(modules = [ViewModelModule::class, DomainModule::class, ApiModule::class])
interface ApplicationComponent {

    fun inject(app: LoadAutoApp)
    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}