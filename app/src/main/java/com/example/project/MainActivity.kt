package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.project.ui.theme.ProjectTheme
import com.google.firebase.FirebaseApp
import presentation.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val app = FirebaseApp.getInstance()
        Log.d("FIREBASE", "Firebase initialized: ${app.name}")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}
