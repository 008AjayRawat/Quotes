package learn.app.data.di

import dagger.Module
import dagger.Provides
import learn.app.data.api.retrofit.QuoteService
import learn.app.data.datasource.QuoteLocalDataSource
import learn.app.data.datasource.QuoteRemoteDataSource
import retrofit2.Retrofit

@Module
class QuoteDataSourceModule {

    @Provides
    fun providesQuoteService(retrofit: Retrofit): QuoteService {
        return retrofit.create(QuoteService::class.java)
    }

}