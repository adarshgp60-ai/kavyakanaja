package com.kavyakanaja.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Onboarding : Screen("onboarding")
    data object Auth : Screen("auth")
    data object Home : Screen("home")
    data object Library : Screen("library")
    data object Explore : Screen("explore")
    data object Favorites : Screen("favorites")
    data object Profile : Screen("profile")
    data object Poets : Screen("poets")
    data object PoemDetail : Screen("poem/{poemId}") {
        fun create(poemId: String) = "poem/$poemId"
    }
}
