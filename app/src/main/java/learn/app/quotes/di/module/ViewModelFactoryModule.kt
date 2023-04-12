package learn.app.quotes.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import learn.app.quotes.core.di.scope.ApplicationScope
import learn.app.quotes.di.ViewModelFactory
import learn.app.quotes.di.scope.FeatureScope

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}