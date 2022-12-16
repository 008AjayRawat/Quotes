package learn.app.quotes.core.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import learn.app.quotes.core.di.module.DatabaseModule
import learn.app.quotes.core.di.module.NetworkModule
import learn.app.quotes.core.di.scope.ApplicationScope
import learn.app.quotes.data.database.QuotesDatabase
import retrofit2.Retrofit

@ApplicationScope
@Component(
    modules = [NetworkModule::class, DatabaseModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): CoreComponent
    }

    fun getRetrofit(): Retrofit

    fun getQuotesDatabase(): QuotesDatabase
}