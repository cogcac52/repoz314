package domain.model

data class Schedule(
    val date: String,
    val isWorkingDay: Boolean,
    val startTime: String?,
    val endTime: String?,
    val hasBreak: Boolean,
    val breakStart: String?,
    val breakEnd: String?
)

