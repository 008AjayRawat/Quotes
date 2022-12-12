package learn.app.quotes.data.dto.domain

data class RandomQuoteDomain(
    val id: String,
    val content: String,
    val author: String,
    val authorSlug: String,
    val tags: List<String>
)