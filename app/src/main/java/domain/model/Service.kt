package domain.model

data class Service(
    val id: String,
    val name: String,
    val duration: Int,
    val price: Int,
    val photoUrl: String?
)

