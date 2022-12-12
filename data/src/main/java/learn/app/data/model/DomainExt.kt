package learn.app.data.model

import learn.app.data.model.domain.QuoteDomainModel
import learn.app.data.model.network.QuoteApiModel

fun QuoteApiModel.toDomainModel(): QuoteDomainModel {
    return QuoteDomainModel(
        id = id,
        content = content,
        author = author,
        authorSlug = authorSlug,
        length = length,
        tags = tags
    )
}