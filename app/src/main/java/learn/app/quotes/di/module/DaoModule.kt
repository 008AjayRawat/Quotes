package learn.app.quotes.di.module

import dagger.Module
import dagger.Provides
import learn.app.quotes.data.database.QuotesDatabase
import learn.app.quotes.data.database.dao.QuotesDao
import learn.app.quotes.di.scope.FeatureScope

@Module
class DaoModule {

    @FeatureScope
    @Provides
    fun provideQuoteDao(database: QuotesDatabase): QuotesDao {
        return database.getQuotesDao()
    }

}