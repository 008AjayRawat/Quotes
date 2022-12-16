package learn.app.quotes.ui

import android.app.Application
import learn.app.quotes.core.di.component.CoreComponent
import learn.app.quotes.core.di.component.DaggerCoreComponent


class QuotesApplication : Application() {

    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

}