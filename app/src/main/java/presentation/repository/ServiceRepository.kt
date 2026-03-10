package presentation.repository

import com.google.firebase.firestore.FirebaseFirestore
import domain.model.Service
import kotlinx.coroutines.tasks.await

class ServiceRepository(private val db: FirebaseFirestore = FirebaseFirestore.getInstance()) {
    suspend fun getServices(): List<Service> {
        val snapshot = db.collection("services").get().await()
        return snapshot.documents.mapNotNull { doc ->
            doc.toObject(Service::class.java)
        }
    }
}
