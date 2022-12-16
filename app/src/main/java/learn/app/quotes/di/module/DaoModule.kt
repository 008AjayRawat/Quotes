package learn.app.quotes.di.module

import dagger.Module
import dagger.Provides
import learn.app.quotes.data.database.QuotesDatabase
import learn.app.quotes.data.database.dao.QuotesDao

@Module
class DaoModule {

    @Provides
    fun provideQuoteDao(database: QuotesDatabase): QuotesDao {
        return database.getQuotesDao()
    }

}