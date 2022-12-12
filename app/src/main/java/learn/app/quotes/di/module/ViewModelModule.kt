package learn.app.quotes.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import learn.app.quotes.di.scope.ViewModelKey
import learn.app.quotes.ui.viewmodel.QuoteViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun bindsQuoteViewModel(quoteViewModel: QuoteViewModel): ViewModel
}