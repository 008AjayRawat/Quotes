package learn.app.quotes.di.module

import dagger.Module
import dagger.Provides
import learn.app.quotes.data.api.QuotesService
import learn.app.quotes.di.scope.FeatureScope
import retrofit2.Retrofit

@Module
class WebServiceModule {

    @FeatureScope
    @Provides
    fun provideQuotesService(retrofit: Retrofit): QuotesService {
        return retrofit.create(QuotesService::class.java)
    }
}