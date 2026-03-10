package domain.model

data class Portfolio(
    val id: String,
    val imageUrl: String,
    val serviceId: String?,
    val caption: String,
    val uploadedAt: Long
)

