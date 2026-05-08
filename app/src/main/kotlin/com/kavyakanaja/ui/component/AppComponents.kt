package com.kavyakanaja.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.navigation.Screen
import com.kavyakanaja.ui.theme.RoyalBlue
import com.kavyakanaja.ui.theme.RoyalBlueDark

@Composable
fun GradientPanel(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Brush.linearGradient(listOf(RoyalBlueDark, RoyalBlue)))
            .padding(20.dp)
    ) {
        content()
    }
}

@Composable
fun SectionTitle(title: String, action: String? = null, onAction: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 18.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        if (action != null) {
            Text(action, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable(onClick = onAction))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PoemCard(poem: Poem, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(poem.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(poem.category, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 4.dp))
            Text(poem.meaning, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 10.dp))
        }
    }
}

@Composable
fun KavyaBottomBar(navController: NavHostController) {
    val items = listOf(
        NavItem("Home", Screen.Home.route, Icons.Default.Home),
        NavItem("Library", Screen.Library.route, Icons.Default.LibraryBooks),
        NavItem("Explore", Screen.Explore.route, Icons.Default.Explore),
        NavItem("Favorites", Screen.Favorites.route, Icons.Default.Favorite),
        NavItem("Profile", Screen.Profile.route, Icons.Default.Person)
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(Screen.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

private data class NavItem(val label: String, val route: String, val icon: ImageVector)
