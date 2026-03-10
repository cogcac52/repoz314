package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import presentation.screens.*

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Services : Screen("services")
    object Booking : Screen("booking")
    object Profile : Screen("profile")
    object AdminDashboard : Screen("admin_dashboard")
}

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = Screen.Login.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Login.route) { LoginScreen() }
        composable(Screen.Services.route) { ServicesScreen() }
        composable(Screen.Booking.route) { BookingScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
        composable(Screen.AdminDashboard.route) { AdminDashboardScreen() }
    }
}

