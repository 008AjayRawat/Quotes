package learn.app.quotes.data.dto.mapper

import learn.app.quotes.data.dto.domain.RandomQuoteDomain
import learn.app.quotes.data.dto.remote.RandomQuoteNetwork

fun RandomQuoteNetwork.toDomain(): RandomQuoteDomain {
    return RandomQuoteDomain(
        id = this.id ?: "",
        content = this.content ?: "",
        author = this.author ?: "",
        authorSlug = this.authorSlug ?: "",
        tags = this.tags ?: emptyList()
    )
}