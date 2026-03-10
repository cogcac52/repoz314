package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Service
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import presentation.repository.ServiceRepository

sealed class ServiceUiState {
    object Loading : ServiceUiState()
    data class Success(val services: List<Service>) : ServiceUiState()
    data class Error(val message: String) : ServiceUiState()
}

class ServiceViewModel(private val repository: ServiceRepository = ServiceRepository()) : ViewModel() {
    private val _uiState = MutableStateFlow<ServiceUiState>(ServiceUiState.Loading)
    val uiState: StateFlow<ServiceUiState> = _uiState

    fun loadServices() {
        viewModelScope.launch {
            _uiState.value = ServiceUiState.Loading
            try {
                val services = repository.getServices()
                _uiState.value = ServiceUiState.Success(services)
            } catch (e: Exception) {
                _uiState.value = ServiceUiState.Error(e.message ?: "Ошибка загрузки")
            }
        }
    }
}

