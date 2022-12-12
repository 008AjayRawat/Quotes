package learn.app.quotes.ui

import android.app.Application
import learn.app.quotes.di.DaggerQuotesComponent
import learn.app.quotes.di.component.QuotesComponent

class QuotesApplication : Application() {

    val appComponent: QuotesComponent by lazy {
        DaggerQuotesComponent.factory().create(applicationContext)
    }
}