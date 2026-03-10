package domain.model

data class ClientHistory(
    val clientId: String,
    val clientName: String,
    val clientPhone: String,
    val totalVisits: Int,
    val notes: List<VisitNote>
)

data class VisitNote(
    val date: String,
    val serviceName: String,
    val note: String
)

