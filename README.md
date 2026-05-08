# Kavya-Kanaja

Kavya-Kanaja is an offline-first Android app for learning Kannada literature with premium Jetpack Compose screens, Room persistence, DataStore settings, ExoPlayer-ready audio, and an AI abstraction layer for word meanings, poem summaries, recommendations, and chat.

## Features

- Splash, onboarding, local auth placeholder, home dashboard, library, explore, favorites, poet corner, poem reader, and profile/settings.
- Material Design 3 Compose UI with a minimalist warm ivory, muted clay, ink blue, and charcoal palette.
- Room entities for poems, poets, favorites, and reading history.
- DataStore onboarding, theme, and font-size preferences.
- AI-ready `AiLiteratureClient` with a local fallback implementation.
- ExoPlayer wrapper for future recitation playback.
- 50 generated sample poems and 10 poet profiles seeded offline.

## Setup

1. Open the project in Android Studio.
2. Let Gradle sync dependencies from Google and Maven Central.
3. Run the `app` configuration on an emulator or device.

## API Setup

The current build uses `LocalAiLiteratureClient` so it works without network keys. To add Gemini or OpenAI:

1. Add the SDK or Retrofit API interface in `com.kavyakanaja.ai`.
2. Store keys through a secure local property or backend proxy.
3. Bind the real client in `di/AppModule.kt`.

## Architecture

`MainActivity` hosts a single Compose navigation graph. UI screens talk to `AppViewModel`, which reads from `KavyaRepository`. The repository is offline-first and backed by Room DAOs. AI and audio are isolated behind small interfaces/classes so cloud and background playback can be added without rewriting screens.

## Folder Structure

- `ai` - AI contracts and local implementation.
- `audio` - ExoPlayer controller.
- `data` - seed data, Room, DataStore, repositories, network-ready layer.
- `di` - Hilt modules.
- `domain` - app models.
- `navigation` - route definitions and NavHost.
- `ui` - Compose screens, components, theme, viewmodels.

## Screenshots

Add screenshots here after running on emulator:

- Splash
- Home
- Poem Detail
- Poet Corner
- Profile

## Future Improvements

- Replace generated samples with curated public-domain poems and licensed audio.
- Add Firebase or backend authentication.
- Add WorkManager downloads, notification reminders, and MediaSession service.
- Add Gemini/OpenAI production client through a backend proxy.
- Add Compose UI tests with screenshot baselines.
