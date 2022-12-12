package learn.app.data.model.domain

data class QuoteDomainModel(
    val id: String,
    val content: String,
    val author: String,
    val authorSlug: String,
    val length: String,
    val tags: List<String>
)
