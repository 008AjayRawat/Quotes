package learn.app.data.model.network

import com.google.gson.annotations.SerializedName

/** Response Object
    {
        _id: string
        // The quotation text
        content: string
        // The full name of the author
        author: string
        // The `slug` of the quote author
        authorSlug: string
        // The length of quote (number of characters)
        length: number
        // An array of tag names for this quote
        tags: string[]
    }
 */

/**
    @author Ajay Rawat
 */
data class QuoteApiModel(
    @SerializedName("_id")
    val id: String,
    val content: String,
    val author: String,
    val authorSlug: String,
    val length: String,
    val tags: List<String>
)

