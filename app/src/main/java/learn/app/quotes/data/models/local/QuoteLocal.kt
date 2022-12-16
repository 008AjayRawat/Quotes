package learn.app.quotes.data.models.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuotesLocal(
    @PrimaryKey
    val id: String,
    val content: String,
    val author: String,
    @ColumnInfo(name = "author_slug") val authorSlug: String,
)
