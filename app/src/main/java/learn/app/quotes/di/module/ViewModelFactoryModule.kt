package learn.app.quotes.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import learn.app.quotes.di.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}