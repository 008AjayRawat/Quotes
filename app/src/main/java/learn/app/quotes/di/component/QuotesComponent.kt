package learn.app.quotes.di.component

import dagger.Component
import learn.app.quotes.core.di.component.CoreComponent
import learn.app.quotes.di.module.DaoModule
import learn.app.quotes.di.module.ViewModelFactoryModule
import learn.app.quotes.di.module.ViewModelModule
import learn.app.quotes.di.module.WebServiceModule
import learn.app.quotes.di.scope.FeatureScope
import learn.app.quotes.ui.fragments.RandomQuoteFragment

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        WebServiceModule::class,
        DaoModule::class
    ]
)
interface QuotesComponent {
//    @Component.Builder
//    interface Builder {
//        fun coreComponent(coreComponent: CoreComponent): Builder
//        fun build(): QuotesComponent
//    }

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): QuotesComponent
    }


    fun inject(randomQuoteFragment: RandomQuoteFragment)
}