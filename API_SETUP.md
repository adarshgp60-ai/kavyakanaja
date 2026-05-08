# API Integration Guide

## Gemini API Setup (Recommended)

### 1. Get API Key
```bash
# Visit https://aistudio.google.com/app/apikeys
# Create a new API key for Android
# Store it in local.properties (don't commit to git)
```

### 2. Add to local.properties
```properties
GEMINI_API_KEY=your_api_key_here
```

### 3. Update build.gradle.kts
```kotlin
android {
    buildTypes {
        debug {
            buildConfigField("String", "GEMINI_API_KEY", "\"${System.getenv("GEMINI_API_KEY")}\"")
        }
    }
}
```

### 4. Add Gemini Dependency
```kotlin
implementation("com.google.ai.client.generativeai:google-generative-ai-kotlin:0.1.0")
```

---

## OpenAI API Setup (Alternative)

### 1. Get API Key
```bash
# Visit https://platform.openai.com/api-keys
# Create a new API key
```

### 2. Add to local.properties
```properties
OPENAI_API_KEY=sk-...
```

### 3. Add OpenAI Dependency
```kotlin
// Use OkHttp + Retrofit to call OpenAI API
```

---

## Firebase Authentication (Future)

### 1. Create Firebase Project
```bash
# Visit https://console.firebase.google.com
# Create new project
```

### 2. Add google-services.json
```bash
# Download google-services.json from Firebase Console
# Place in app/ directory
```

### 3. Add Dependencies
```kotlin
implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
implementation("com.google.firebase:firebase-analytics-ktx:21.6.1")
```

---

## Retrofit Network Setup

### Example API Service
```kotlin
interface KavyaKanajaApiService {
    @GET("poems")
    suspend fun getPoems(): Response<List<Poem>>
    
    @POST("poems/{id}/bookmark")
    suspend fun bookmarkPoem(@Path("id") poemId: String): Response<Void>
}
```

### Create Retrofit Instance in DIModule.kt
```kotlin
@Provides
@Singleton
fun provideKavyaKanajaApiService(): KavyaKanajaApiService {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()
        .create(KavyaKanajaApiService::class.java)
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(LoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}
```

---

## Environment Variables

Create `.env` file (don't commit):
```
GEMINI_API_KEY=your_key
OPENAI_API_KEY=your_key
FIREBASE_PROJECT_ID=your_project_id
```

Load in build.gradle.kts:
```kotlin
val file = rootProject.file(".env")
if (file.exists()) {
    val envProperties = java.util.Properties()
    envProperties.load(file.inputStream())
    envProperties.forEach { (key, value) ->
        project.ext[key.toString()] = value.toString()
    }
}
```

---

## Security Best Practices

1. **Never commit API keys** - Add to `.gitignore`
2. **Use BuildConfig** - Store keys in BuildConfig
3. **Rotate keys regularly** - Update keys periodically
4. **Use API scoping** - Limit API key permissions
5. **Monitor usage** - Check API dashboard for abuse
6. **Use HTTPS only** - All API calls must use HTTPS

---

## Testing API Integration

### Local Testing
```bash
./gradlew runDebugUnitTests
```

### Connected Device Testing
```bash
./gradlew connectedAndroidTest
```

---

## Resources

- [Gemini API Docs](https://ai.google.dev/docs)
- [OpenAI API Docs](https://platform.openai.com/docs)
- [Firebase Setup](https://firebase.google.com/docs/android/setup)
- [Retrofit Documentation](https://square.github.io/retrofit/)

