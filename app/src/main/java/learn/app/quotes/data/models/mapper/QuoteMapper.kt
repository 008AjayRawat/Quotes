package learn.app.quotes.data.models.mapper

import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.remote.QuoteNetwork
import learn.app.quotes.data.models.local.QuotesLocal

fun QuoteNetwork.toDomain(): QuoteDomain {
    return QuoteDomain(
        id = this.id ?: "",
        content = this.content ?: "",
        author = this.author ?: "",
        authorSlug = this.authorSlug ?: "",
        tags = this.tags ?: emptyList()
    )
}


fun QuoteNetwork.toLocal(): QuotesLocal {
    return QuotesLocal(
        id = this.id ?: "",
        content = this.content ?: "",
        author = this.author ?: "",
        authorSlug = this.authorSlug ?: "",
    )
}

fun QuotesLocal.toDomain(): QuoteDomain {
    return QuoteDomain(
        id = this.id ?: "",
        content = this.content ?: "",
        author = this.author ?: "",
        authorSlug = this.authorSlug ?: "",
        tags = emptyList()
    )
}