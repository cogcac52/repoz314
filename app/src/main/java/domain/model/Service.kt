package domain.model

// Добавлен конструктор без аргументов для Firestore

data class Service(
    val id: String = "",
    val name: String = "",
    val duration: Int = 0,
    val price: Int = 0,
    val photoUrl: String? = null
)
