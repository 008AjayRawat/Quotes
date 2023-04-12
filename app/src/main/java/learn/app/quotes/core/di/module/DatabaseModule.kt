package learn.app.quotes.core.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import learn.app.quotes.core.di.scope.ApplicationScope
import learn.app.quotes.data.database.QuotesDatabase

@Module
class DatabaseModule {

    @ApplicationScope
    @Provides
    fun provideRoomDatabase(application: Application): QuotesDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            QuotesDatabase::class.java,
            "quotes-db"
        ).build()
    }

}