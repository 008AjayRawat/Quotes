package learn.app.quotes.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import learn.app.quotes.di.module.NetworkModule
import learn.app.quotes.di.module.ViewModelFactoryModule
import learn.app.quotes.di.module.ViewModelModule
import learn.app.quotes.di.module.WebServiceModule
import learn.app.quotes.ui.QuotesApplication
import learn.app.quotes.ui.fragments.RandomQuoteFragment

@Component(
    modules = [ViewModelFactoryModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        WebServiceModule::class]
)
interface QuotesComponent {
    companion object {
        val Application.appComponent
            get() = (this as QuotesApplication).appComponent
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): QuotesComponent
    }


    fun provideContext(): Context

    fun inject(randomQuoteFragment: RandomQuoteFragment)
}