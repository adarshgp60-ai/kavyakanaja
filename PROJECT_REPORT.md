# Kavya-Kanaja Project Report

## 1. Introduction

Kavya-Kanaja is an Android application designed to make Kannada literature more approachable for Gen-Z learners. The app combines a modern mobile reading experience with educational features such as poem explanations, poet biographies, favorites, reading progress, and AI-ready meaning assistance.

## 2. Problem Statement

Kannada poetry and classical literature are often difficult for new learners because of unfamiliar vocabulary, lack of contextual explanation, and limited modern digital presentation. Kavya-Kanaja addresses this by presenting poems in a clean mobile app with simple explanations, progress tracking, and future-ready AI support.

## 3. Objectives

- Provide an elegant Kannada literature reading experience.
- Help users discover poems by category and mood.
- Explain difficult words and poem meanings.
- Introduce users to important Kannada poets.
- Support offline-first learning.
- Build a scalable Android architecture suitable for future cloud and AI integration.

## 4. Methodology

The app was built using a modern Android stack. Jetpack Compose provides the UI, Hilt manages dependencies, Room stores local content, DataStore stores preferences, and a repository layer separates data access from UI logic. AI and audio features are implemented through abstraction layers so real services can be connected later.

## 5. System Architecture

The project follows MVVM and repository-pattern architecture.

- UI Layer: Compose screens and reusable components.
- ViewModel Layer: State handling with Kotlin Flow.
- Domain Layer: Data models for poems, poets, favorites, history, and user profile.
- Data Layer: Room DAOs, repository implementation, seed data, and preferences.
- AI Layer: AI client interface and local fallback implementation.
- Audio Layer: ExoPlayer-ready controller.
- DI Layer: Hilt modules.

## 6. Modules

### Splash and Onboarding

Shows the app identity and introduces discovery, listening, and AI-learning features.

### Authentication

Provides login, signup, and guest-mode UI with validation. This is prepared for future Firebase or backend authentication.

### Home

Displays greeting, daily quote, progress stats, poem of the day, daily challenge, categories, moods, poets, and recommendations.

### Library and Explore

Allows browsing poems and searching by title, content, or category.

### Poem Detail

Provides a poem reader, favorite action, audio controls placeholder, tappable word meaning, AI summary, and chat assistant.

### Poet's Corner

Displays poet biographies, eras, awards, influence, and Jnanpith information where available.

### Favorites

Displays poems saved by the user.

### Profile and Settings

Shows reading streak, completed poems, listening hours, theme setting, font-size control, analytics, and achievements.

## 7. Database Design

Room entities:

- `Poem`: title, poetId, content, category, meaning, audioUrl, dateAdded, difficultyLevel.
- `Poet`: name, biography, imageUrl, awards, era, Jnanpith info, influence.
- `Favorite`: userId, poemId, dateAdded.
- `ReadingHistory`: userId, poemId, lastRead, readCount.

## 8. Testing

The project includes unit test scaffolding for the AI fallback client and sample data volume checks. Manual testing should verify onboarding, navigation, poem reading, favorites, AI summary, theme toggle, and APK installation.

## 9. Results

The project builds into a debug APK and can be installed on an Android emulator or device. It demonstrates a complete learning flow from onboarding to poem discovery, poem reading, AI-style assistance, and progress tracking.

## 10. Limitations

- Poems are sample/generated content and should be replaced with curated public-domain or licensed content for production.
- AI responses currently use a local fallback implementation.
- Audio playback architecture exists, but real audio files/services need to be connected.
- Authentication is UI-ready but not connected to Firebase/backend.

## 11. Future Enhancements

- Real Gemini/OpenAI integration through secure backend proxy.
- Firebase login and cloud sync.
- Licensed Kannada poem recitations.
- Download manager and offline audio cache.
- Notification reminders.
- AI-generated quizzes.
- Community discussion and poet events.

## 12. Conclusion

Kavya-Kanaja successfully demonstrates a modern Android MVP for Kannada literature learning. It combines clean UI, offline content, scalable architecture, and AI-ready features, making it suitable for academic submission and future product development.
