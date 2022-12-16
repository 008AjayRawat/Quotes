package learn.app.quotes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import learn.app.quotes.data.database.dao.QuotesDao
import learn.app.quotes.data.models.local.QuotesLocal

@Database(entities = [QuotesLocal::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun getQuotesDao(): QuotesDao

}