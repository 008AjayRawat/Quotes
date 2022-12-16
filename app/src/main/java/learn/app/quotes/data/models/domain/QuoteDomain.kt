package learn.app.quotes.data.models.domain

data class QuoteDomain(
    val id: String,
    val content: String,
    val author: String,
    val authorSlug: String,
    val tags: List<String>
)