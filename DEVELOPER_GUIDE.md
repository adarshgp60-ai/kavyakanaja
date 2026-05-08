# Developer Quick Reference

## Quick Build Commands

```bash
# Clean build
./gradlew clean build

# Run tests
./gradlew test

# Connected device tests
./gradlew connectedAndroidTest

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing config)
./gradlew assembleRelease

# Install debug APK on device
./gradlew installDebug

# Run emulator and app
./gradlew runDebug

# Check dependencies
./gradlew dependencies

# Update dependencies
./gradlew dependencyUpdates
```

---

## IDE Setup (Android Studio)

1. **Open Project**: File > Open > Select `kavya-kanaja` folder
2. **Sync Gradle**: File > Sync Now
3. **Configure SDK**: Settings > Appearance & Behavior > System Settings > Android SDK
4. **Run Configuration**: 
   - Edit Configurations > Add > Android App
   - Select "app" module
   - Choose device/emulator

---

## Project Navigation

### Key Packages

| Package | Purpose |
|---------|---------|
| `domain.model` | Data classes and entities |
| `data.database` | Room DAOs and database |
| `data.repository` | Repository implementations |
| `ui.screen` | Compose screens |
| `ui.theme` | Material Design theme |
| `ui.viewmodel` | ViewModels for state |
| `navigation` | App navigation graph |
| `di` | Hilt dependency injection |
| `utils` | Utilities and helpers |
| `ai` | AI service layer |

---

## Adding New Features

### 1. Create New Screen

```kotlin
@Composable
fun MyNewScreen(
    viewModel: MyViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit = {}
) {
    // Compose UI here
}
```

### 2. Create ViewModel

```kotlin
@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: IMyRepository
) : ViewModel() {
    // State management
}
```

### 3. Add to Navigation

```kotlin
sealed class Route(val route: String) {
    object MyScreen : Route("my_screen")
}

// In AppNavGraph:
composable(Route.MyScreen.route) {
    MyNewScreen()
}
```

---

## Database Operations

### Insert Data

```kotlin
val poem = Poem(
    title = "Title",
    poetId = "poet_1",
    content = "Content",
    category = "Bhakti",
    meaning = "Meaning"
)
viewModelScope.launch {
    poemRepository.insertPoem(poem)
}
```

### Query Data

```kotlin
val poems = poemRepository.getAllPoems()
    .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
```

### Update Data

```kotlin
viewModelScope.launch {
    poemRepository.updatePoem(updatedPoem)
}
```

---

## Testing

### Unit Test Template

```kotlin
@RunWith(RobolectricTestRunner::class)
class MyViewModelTest {
    private lateinit var viewModel: MyViewModel
    
    @Before
    fun setup() {
        // Initialize mocks and ViewModel
    }
    
    @Test
    fun testSomething() {
        // Arrange, Act, Assert
    }
}
```

### UI Test Template

```kotlin
@RunWith(AndroidJUnit4::class)
class MyScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun testUI() {
        composeTestRule.setContent {
            MyNewScreen()
        }
        composeTestRule.onNodeWithText("Hello").assertIsDisplayed()
    }
}
```

---

## Code Style Guide

### Naming Conventions

```kotlin
// Classes: PascalCase
class PoemViewModel

// Functions: camelCase
fun loadPoems()

// Constants: UPPER_SNAKE_CASE
const val MAX_POEMS = 100

// Variables: camelCase
val poemList = emptyList<Poem>()

// Composables: PascalCase
@Composable
fun PoemCard()
```

### Formatting

- Indent: 4 spaces
- Line length: 120 characters max
- One class per file
- Imports: Auto-organized by IDE

---

## Common Issues & Solutions

### Issue: Build fails with "Database error"
**Solution**: Run `./gradlew clean build`

### Issue: Manifest merge failed
**Solution**: Check AndroidManifest.xml permissions are correct

### Issue: Compose compilation error
**Solution**: Update Compose BOM version in build.gradle.kts

### Issue: Hilt injection fails
**Solution**: Ensure app inherits from `HiltAndroidApp`

---

## Performance Tips

1. **Use LazyColumn** instead of Column for lists
2. **Remember composables** with remember { }
3. **Use derive StateFlow** for computed values
4. **Load images** with Coil efficiently
5. **Cache API responses** in Room
6. **Use Flow.stateIn()** for proper lifecycle

---

## Useful Resources

- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose/documentation)
- [Material Design 3](https://material-io.cn/design)
- [Room Documentation](https://developer.android.com/training/data-storage/room)
- [Hilt Guide](https://dagger.dev/hilt/)
- [Coroutines Docs](https://kotlinlang.org/docs/coroutines-overview.html)

---

## Directory Shortcuts

```bash
# Project root
cd /path/to/kavya-kanaja

# App source
cd app/src/main/kotlin/com/kavyakanaja

# Resources
cd app/src/main/res

# Tests
cd app/src/test
```

---

## Git Workflow

```bash
# Create feature branch
git checkout -b feature/my-feature

# Make changes
git add .

# Commit with descriptive message
git commit -m "Add: New poem screen"

# Push to remote
git push origin feature/my-feature

# Create pull request
# After review -> merge to main
```

---

## Emulator Setup

```bash
# List available emulators
emulator -list-avds

# Start emulator
emulator -avd Pixel_5_API_34

# Connect to device
adb connect <device_ip>:5555

# Push file to device
adb push local_path /data/local/tmp/

# Pull file from device
adb pull /data/local/tmp/file local_path
```

---

## Version Control

```
.gitignore includes:
- .gradle/
- /build
- .idea/
- *.iml
- local.properties
- *.apk
- .cxx/
```

---

## Contact

For team collaboration:
- Issues: GitHub Issues
- Discussions: GitHub Discussions
- Code Reviews: Pull Requests

---

**Last Updated**: May 7, 2026
**Team**: Development Squad
**Version**: 1.0
