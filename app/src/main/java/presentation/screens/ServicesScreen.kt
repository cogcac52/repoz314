package presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ServiceUiModel(
    val id: String,
    val name: String,
    val price: Int,
    val duration: Int
)

@Composable
fun ServicesScreen(
    services: List<ServiceUiModel> = listOf(
        ServiceUiModel("1", "Стрижка", 800, 30),
        ServiceUiModel("2", "Окрашивание", 2000, 90),
        ServiceUiModel("3", "Укладка", 600, 20)
    ),
    onServiceClick: (ServiceUiModel) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Услуги", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(services) { service ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = service.name, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "Цена: ${service.price} ₽")
                            Text(text = "Время: ${service.duration} мин")
                        }
                        Button(
                            onClick = { onServiceClick(service) },
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) {
                            Text("Выбрать")
                        }
                    }
                }
            }
        }
    }
}
