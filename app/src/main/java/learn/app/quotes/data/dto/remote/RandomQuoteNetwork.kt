package learn.app.quotes.data.dto.remote

/**
_id: string
content: string --> The quotation text
author: string --> The full name of the author
authorSlug: string --> The `slug` of the quote author
length: number --> The length of quote (number of characters)
tags: string[] -->An array of tag names for this quote
 */
data class RandomQuoteNetwork(
    val id: String?,
    val content: String?,
    val author: String?,
    val authorSlug: String?,
    val tags: List<String>?
)