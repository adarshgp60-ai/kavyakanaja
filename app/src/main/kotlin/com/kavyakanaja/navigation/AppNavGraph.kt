package com.kavyakanaja.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.kavyakanaja.ui.screen.AuthScreen
import com.kavyakanaja.ui.screen.ExploreScreen
import com.kavyakanaja.ui.screen.FavoritesScreen
import com.kavyakanaja.ui.screen.HomeScreen
import com.kavyakanaja.ui.screen.LibraryScreen
import com.kavyakanaja.ui.screen.OnboardingScreen
import com.kavyakanaja.ui.screen.PoemDetailScreen
import com.kavyakanaja.ui.screen.PoetsScreen
import com.kavyakanaja.ui.screen.ProfileScreen
import com.kavyakanaja.ui.screen.SplashScreen
import com.kavyakanaja.ui.viewmodel.AppViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val viewModel: AppViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController, viewModel) }
        composable(Screen.Onboarding.route) { OnboardingScreen(navController, viewModel) }
        composable(Screen.Auth.route) { AuthScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController, viewModel) }
        composable(Screen.Library.route) { LibraryScreen(navController, viewModel) }
        composable(Screen.Explore.route) { ExploreScreen(navController, viewModel) }
        composable(Screen.Favorites.route) { FavoritesScreen(navController, viewModel) }
        composable(Screen.Profile.route) { ProfileScreen(viewModel) }
        composable(Screen.Poets.route) { PoetsScreen(viewModel) }
        composable(
            route = Screen.PoemDetail.route,
            arguments = listOf(navArgument("poemId") { type = NavType.StringType })
        ) { backStackEntry ->
            PoemDetailScreen(
                navController = navController,
                viewModel = viewModel,
                poemId = backStackEntry.arguments?.getString("poemId").orEmpty()
            )
        }
    }
}
