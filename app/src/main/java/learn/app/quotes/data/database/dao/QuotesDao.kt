package learn.app.quotes.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import learn.app.quotes.data.models.local.QuotesLocal

@Dao
interface QuotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quotesLocal: QuotesLocal)

    @Query("SELECT * FROM quotes ORDER BY random() LIMIT 1")
    suspend fun getRandomQuote(): QuotesLocal?

    @Query("SELECT * FROM quotes")
    suspend fun getQuoteList(): List<QuotesLocal>
}