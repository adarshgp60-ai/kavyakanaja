package com.kavyakanaja.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kavyakanaja.ai.PoemAnalysis
import com.kavyakanaja.ai.WordMeaning
import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet
import com.kavyakanaja.navigation.Screen
import com.kavyakanaja.ui.component.GradientPanel
import com.kavyakanaja.ui.component.KavyaBottomBar
import com.kavyakanaja.ui.component.PoemCard
import com.kavyakanaja.ui.component.SectionTitle
import com.kavyakanaja.ui.theme.RoyalBlue
import com.kavyakanaja.ui.theme.RoyalBlueDark
import com.kavyakanaja.ui.viewmodel.AppViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val alpha by animateFloatAsState(targetValue = 1f, label = "splashAlpha")
    LaunchedEffect(state.settings.onboardingComplete) {
        delay(2_000)
        navController.navigate(if (state.settings.onboardingComplete) Screen.Home.route else Screen.Onboarding.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }
    Box(
        Modifier.fillMaxSize().background(Brush.linearGradient(listOf(RoyalBlueDark, RoyalBlue))),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.alpha(alpha)) {
            Text("ಕಾವ್ಯ-ಕಣಜ", style = MaterialTheme.typography.displaySmall, color = Color.White)
            Text("Kavya-Kanaja", style = MaterialTheme.typography.titleLarge, color = Color.White)
            Spacer(Modifier.height(12.dp))
            Text("Reviving Kannada Literature for the Next Generation", color = Color.White, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun OnboardingScreen(navController: NavHostController, viewModel: AppViewModel) {
    val pages = listOf(
        "Discover Kannada Poetry" to "Explore classical, bhakti, nature, love, and patriotic poetry in a modern reader.",
        "Listen to Audio Recitations" to "Enjoy recitations with playback speed, reading progress, and offline-ready architecture.",
        "Learn Meanings Instantly With AI" to "Tap difficult words and ask Kavya AI for simple Kannada and English explanations."
    )
    var page by remember { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            TextButton(onClick = {
                viewModel.completeOnboarding()
                navController.navigate(Screen.Auth.route) { popUpTo(Screen.Onboarding.route) { inclusive = true } }
            }) { Text("Skip") }
        }
        GradientPanel(Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(150.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.18f)), contentAlignment = Alignment.Center) {
                    Text("ಕ", style = MaterialTheme.typography.displaySmall, color = Color.White)
                }
                Spacer(Modifier.height(28.dp))
                Text(pages[page].first, style = MaterialTheme.typography.headlineMedium, color = Color.White, textAlign = TextAlign.Center)
                Text(pages[page].second, color = Color.White.copy(alpha = 0.9f), textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp))
            }
        }
        Row(horizontalArrangement = Arrangement.Center) {
            pages.indices.forEach {
                Box(
                    Modifier.padding(4.dp).size(if (it == page) 24.dp else 8.dp, 8.dp)
                        .clip(CircleShape).background(if (it == page) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline)
                )
            }
        }
        Button(
            onClick = {
                if (page < pages.lastIndex) page++ else {
                    viewModel.completeOnboarding()
                    navController.navigate(Screen.Auth.route) { popUpTo(Screen.Onboarding.route) { inclusive = true } }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text(if (page == pages.lastIndex) "Get Started" else "Next") }
    }
}

@Composable
fun AuthScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var signup by remember { mutableStateOf(false) }
    val validEmail = email.contains("@") && email.contains(".")
    val validPassword = password.length >= 6
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
        Text(if (signup) "Create Account" else "Welcome Back", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Continue your Kannada literature journey.", modifier = Modifier.padding(top = 8.dp, bottom = 24.dp))
        OutlinedTextField(email, { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth(), isError = email.isNotBlank() && !validEmail)
        OutlinedTextField(password, { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth().padding(top = 12.dp), isError = password.isNotBlank() && !validPassword)
        Button(
            onClick = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Auth.route) { inclusive = true } } },
            enabled = validEmail && validPassword,
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
        ) { Text(if (signup) "Sign Up" else "Login") }
        OutlinedButton(onClick = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Auth.route) { inclusive = true } } }, modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
            Text("Continue as Guest")
        }
        TextButton(onClick = { signup = !signup }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(if (signup) "Already have an account? Login" else "New here? Sign up")
        }
        Text("Google Sign-In architecture placeholder", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
    }
}

@Composable
fun HomeScreen(navController: NavHostController, viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(bottomBar = { KavyaBottomBar(navController) }) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding).padding(horizontal = 20.dp)) {
            item {
                Spacer(Modifier.height(20.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text("Namaskara, ${state.userName}", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text("Daily quote: ಭಾಷೆ ಬದುಕಿನ ಉಸಿರು.")
                    }
                    Box(Modifier.size(48.dp).clip(CircleShape).background(MaterialTheme.colorScheme.secondary), contentAlignment = Alignment.Center) { Text("ಕ", color = Color.White) }
                }
                SectionTitle("Your Progress")
                ProgressRow(poemsCompleted = state.poems.take(18).size, favorites = state.favorites.size, xp = 1280)
                SectionTitle("Poem of the Day")
                val poem = state.poems.firstOrNull()
                if (poem != null) GradientPanel(Modifier.fillMaxWidth().clickable { navController.navigate(Screen.PoemDetail.create(poem.id)) }) {
                    Column {
                        Text(poem.title, style = MaterialTheme.typography.headlineMedium, color = Color.White)
                        Text(poem.meaning, color = Color.White.copy(alpha = 0.9f), modifier = Modifier.padding(top = 10.dp))
                    }
                }
                DailyChallengeCard()
                SectionTitle("Categories")
                CategoryRow(listOf("Bhakti", "Nature", "Love", "Philosophy", "Patriotism", "Classical Kannada"))
                SectionTitle("Choose Your Mood")
                CategoryRow(listOf("Calm", "Inspired", "Focused", "Devotional", "Curious"))
                SectionTitle("Continue Reading")
            }
            items(state.poems.take(5)) { poem ->
                PoemCard(poem, onClick = { navController.navigate(Screen.PoemDetail.create(poem.id)) }, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp))
            }
            item { SectionTitle("Trending Poets", action = "View all", onAction = { navController.navigate(Screen.Poets.route) }) }
            item { PoetRow(state.poets) }
            item { SectionTitle("AI Recommended Poems") }
            items(state.poems.drop(5).take(4)) { poem ->
                PoemCard(poem, onClick = { navController.navigate(Screen.PoemDetail.create(poem.id)) }, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp))
            }
        }
    }
}

@Composable
private fun ProgressRow(poemsCompleted: Int, favorites: Int, xp: Int) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        StatTile("Streak", "7d", Modifier.weight(1f))
        StatTile("Read", "$poemsCompleted", Modifier.weight(1f))
        StatTile("Saved", "$favorites", Modifier.weight(1f))
        StatTile("XP", "$xp", Modifier.weight(1f))
    }
}

@Composable
private fun StatTile(label: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun DailyChallengeCard() {
    Card(
        Modifier.fillMaxWidth().padding(top = 14.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Daily Challenge", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text("Read one poem, save one favorite, and ask Kavya AI one question.", modifier = Modifier.padding(top = 6.dp))
            Text("+120 XP", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Composable
private fun CategoryRow(categories: List<String>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(categories) { category -> AssistChip(onClick = {}, label = { Text(category) }) }
    }
}

@Composable
private fun PoetRow(poets: List<Poet>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(poets.take(10)) { poet ->
            Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.width(180.dp)) {
                Column(Modifier.padding(14.dp)) {
                    Box(Modifier.size(44.dp).clip(CircleShape).background(RoyalBlue), contentAlignment = Alignment.Center) { Text(poet.name.take(1), color = Color.White) }
                    Text(poet.name, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp))
                    Text(poet.era, color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}

@Composable
fun LibraryScreen(navController: NavHostController, viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(bottomBar = { KavyaBottomBar(navController) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(20.dp)) {
            item { Text("Library", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold) }
            items(state.poems) { poem -> PoemCard(poem, { navController.navigate(Screen.PoemDetail.create(poem.id)) }, Modifier.fillMaxWidth().padding(vertical = 6.dp)) }
        }
    }
}

@Composable
fun ExploreScreen(navController: NavHostController, viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    var query by remember { mutableStateOf("") }
    val results = state.poems.filter { it.title.contains(query, true) || it.category.contains(query, true) || it.content.contains(query, true) }
    Scaffold(bottomBar = { KavyaBottomBar(navController) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(20.dp)) {
            item {
                Text("Explore", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                OutlinedTextField(query, { query = it }, leadingIcon = { Icon(Icons.Default.Search, null) }, label = { Text("Search poems, poets, categories") }, modifier = Modifier.fillMaxWidth().padding(top = 14.dp))
                SectionTitle("Trending Searches")
                CategoryRow(listOf("Kuvempu", "Vachana", "Nature", "Jnanpith", "Patriotism"))
            }
            items(if (query.isBlank()) state.poems.take(12) else results) { poem ->
                PoemCard(poem, { navController.navigate(Screen.PoemDetail.create(poem.id)) }, Modifier.fillMaxWidth().padding(vertical = 6.dp))
            }
        }
    }
}

@Composable
fun FavoritesScreen(navController: NavHostController, viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val favoritePoemIds = state.favorites.map { it.poemId }.toSet()
    val poems = state.poems.filter { it.id in favoritePoemIds }
    Scaffold(bottomBar = { KavyaBottomBar(navController) }) { padding ->
        LazyColumn(Modifier.padding(padding).padding(20.dp)) {
            item { Text("Favorites", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold) }
            if (poems.isEmpty()) item { Text("Saved poems and poets will appear here.", modifier = Modifier.padding(top = 18.dp)) }
            items(poems) { poem -> PoemCard(poem, { navController.navigate(Screen.PoemDetail.create(poem.id)) }, Modifier.fillMaxWidth().padding(vertical = 6.dp)) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PoemDetailScreen(navController: NavHostController, viewModel: AppViewModel, poemId: String) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val poem = state.poems.firstOrNull { it.id == poemId }
    val poet = state.poets.firstOrNull { it.id == poem?.poetId }
    var wordMeaning by remember { mutableStateOf<WordMeaning?>(null) }
    var analysis by remember { mutableStateOf<PoemAnalysis?>(null) }
    var showAi by remember { mutableStateOf(false) }
    LaunchedEffect(poemId) { viewModel.markRead(poemId) }
    if (poem == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Loading poem...") }
        return
    }
    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding).padding(20.dp)) {
            item {
                Text(poem.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                Text(poet?.name ?: "Kannada Poet", color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 4.dp))
                Row(Modifier.padding(vertical = 12.dp)) {
                    IconButton(onClick = { viewModel.toggleFavorite(poem.id) }) { Icon(Icons.Default.Bookmark, "Bookmark") }
                    IconButton(onClick = {}) { Icon(Icons.Default.Share, "Share") }
                    IconButton(onClick = {}) { Icon(Icons.Default.Download, "Download offline") }
                    IconButton(onClick = {}) { Icon(Icons.Default.PlayArrow, "Play audio") }
                }
                Card(shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
                    FlowRow(Modifier.padding(18.dp), horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        poem.content.split(Regex("\\s+")).forEachIndexed { index, word ->
                            Text(
                                text = word,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = (18 * state.settings.fontScale).coerceIn(15f, 26f).sp),
                                modifier = Modifier
                                    .background(if (index == 0) MaterialTheme.colorScheme.primary.copy(alpha = 0.14f) else Color.Transparent, RoundedCornerShape(6.dp))
                                    .clickable { viewModel.explainWord(word.trim(',', '.', '।'), poem) { wordMeaning = it } }
                                    .padding(2.dp)
                            )
                        }
                    }
                }
                SectionTitle("AI Summary")
                Button(onClick = { viewModel.analyze(poem) { analysis = it } }) { Text("Generate Poem Analysis") }
                AnimatedVisibility(analysis != null) {
                    AnalysisCard(analysis!!)
                }
                SectionTitle("Ask Kavya AI")
                Button(onClick = { showAi = true }) { Text("Open Chat Assistant") }
            }
        }
    }
    wordMeaning?.let {
        ModalBottomSheet(onDismissRequest = { wordMeaning = null }) {
            Column(Modifier.padding(24.dp)) {
                Text(it.word, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                Text("Simple Kannada: ${it.simpleKannada}", modifier = Modifier.padding(top = 12.dp))
                Text("English: ${it.english}", modifier = Modifier.padding(top = 8.dp))
                Text("Pronunciation: ${it.pronunciation}", modifier = Modifier.padding(top = 8.dp))
                Text("Usage: ${it.usage}", modifier = Modifier.padding(top = 8.dp, bottom = 24.dp))
            }
        }
    }
    if (showAi) AiChatDialog(viewModel) { showAi = false }
}

@Composable
private fun AnalysisCard(analysis: PoemAnalysis) {
    Card(Modifier.fillMaxWidth().padding(top = 12.dp), shape = RoundedCornerShape(8.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text("Meaning: ${analysis.summary}")
            Text("Tone: ${analysis.emotionalTone}", modifier = Modifier.padding(top = 8.dp))
            Text("Literary analysis: ${analysis.literaryAnalysis}", modifier = Modifier.padding(top = 8.dp))
            Text("Moral message: ${analysis.moralMessage}", modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Composable
private fun AiChatDialog(viewModel: AppViewModel, onDismiss: () -> Unit) {
    var message by remember { mutableStateOf("") }
    var reply by remember { mutableStateOf("Ask anything about Kannada literature.") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Ask Kavya AI") },
        text = {
            Column {
                Text(reply)
                OutlinedTextField(message, { message = it }, label = { Text("Your question") }, modifier = Modifier.fillMaxWidth().padding(top = 12.dp))
            }
        },
        confirmButton = { TextButton(onClick = { viewModel.chat(message) { reply = it } }) { Text("Ask") } },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Close") } }
    )
}

@Composable
fun PoetsScreen(viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    var query by remember { mutableStateOf("") }
    val poets = state.poets.filter { it.name.contains(query, true) || it.era.contains(query, true) }
    LazyColumn(Modifier.fillMaxSize().padding(20.dp)) {
        item {
            Text("Poet's Corner", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            OutlinedTextField(query, { query = it }, label = { Text("Search or filter by era") }, modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp))
        }
        items(poets) { poet ->
            Card(Modifier.fillMaxWidth().padding(vertical = 7.dp), shape = RoundedCornerShape(8.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text(poet.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("${poet.era} • ${poet.awards}", color = MaterialTheme.colorScheme.primary)
                    Text(poet.biography, modifier = Modifier.padding(top = 8.dp))
                    if (poet.jnanpithInfo.isNotBlank()) Text(poet.jnanpithInfo, modifier = Modifier.padding(top = 8.dp))
                    Text("Influence: ${poet.influence}", modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { padding ->
        LazyColumn(Modifier.padding(padding).padding(20.dp)) {
            item {
                Text("Profile", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                GradientPanel(Modifier.fillMaxWidth().padding(top = 16.dp)) {
                    Column {
                        Text("Guest Reader", style = MaterialTheme.typography.titleLarge, color = Color.White)
                        Text("7 day streak • 18 poems completed • 3.5 listening hours", color = Color.White.copy(alpha = 0.9f))
                    }
                }
                SectionTitle("Settings")
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.DarkMode, null)
                        Text("Dark mode", modifier = Modifier.padding(start = 10.dp))
                    }
                    Switch(checked = state.settings.darkMode, onCheckedChange = viewModel::setDarkMode)
                }
                Text("Font size", modifier = Modifier.padding(top = 18.dp))
                Slider(value = state.settings.fontScale, onValueChange = viewModel::setFontScale, valueRange = 0.85f..1.35f)
                SectionTitle("Analytics")
                Text("Favorite genres: Bhakti, Nature, Patriotism")
                Text("Daily challenge: Read one poem and ask Kavya AI one question.", modifier = Modifier.padding(top = 8.dp))
                SectionTitle("Achievements")
                AchievementList()
                SectionTitle("About App")
                Text("Kavya-Kanaja is an offline-first Kannada literature learning app with AI-ready architecture.")
            }
        }
    }
}

@Composable
private fun AchievementList() {
    val achievements = listOf(
        "First Recitation" to "Listen to your first poem",
        "Word Explorer" to "Tap 10 difficult words",
        "Kannada Streak" to "Read for 7 days",
        "Poet Scholar" to "Explore 5 poet biographies"
    )
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        achievements.forEachIndexed { index, achievement ->
            Card(shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        Modifier.size(36.dp).clip(CircleShape).background(if (index < 2) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(if (index < 2) "Y" else "-", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Column(Modifier.padding(start = 12.dp)) {
                        Text(achievement.first, fontWeight = FontWeight.Bold)
                        Text(achievement.second, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
