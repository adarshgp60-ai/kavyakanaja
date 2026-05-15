# Final Submission Summary

## Project Title

Kavya-Kanaja: National Pride

## Project Type

Android mobile application for Kannada literature learning.

## Objective

Kavya-Kanaja modernizes Kannada poetry discovery and learning for young users through a clean Android interface, offline sample content, poet biographies, favorites, progress tracking, and AI-ready explanation features.

## Current Completion Status

This submission is a working MVP suitable for academic demo, internship review, portfolio presentation, and hackathon-style evaluation. It builds as an Android APK and runs on an emulator or Android device.

## Major Implemented Features

- Splash screen and onboarding flow.
- Login/signup/guest-mode UI with validation.
- Home dashboard with poem of the day, quote, progress stats, daily challenge, categories, mood chips, trending poets, and AI recommendations.
- Library and explore screens.
- Poem detail reader with bookmark, share/download UI actions, adjustable text size, tappable word explanation, AI summary, and Kavya AI chat dialog.
- Poet's Corner with search/filter and biography cards.
- Favorites screen.
- Profile/settings screen with dark mode, font size, analytics, and achievement badges.
- Offline-first Room database architecture with seeded poems and poets.
- DataStore preferences for onboarding, theme, and font size.
- Hilt dependency injection.
- Repository pattern and MVVM structure.
- AI abstraction layer with local fallback client.
- ExoPlayer-ready audio controller.
- Adaptive launcher icon for app drawer/home screen.

## Tech Stack

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose
- Hilt
- Room
- DataStore
- Retrofit/OkHttp architecture
- Coil dependency
- ExoPlayer/Media3 architecture
- Coroutines and Flow
- JUnit test scaffolding
- Gradle Kotlin DSL

## Demo Notes

The app uses generated/sample Kannada-literature content and local AI fallback responses so it can run without paid cloud API keys. Real Gemini/OpenAI and licensed audio can be connected later using the existing abstraction layers.

## GitHub Repository

https://github.com/adarshgp60-ai/kavyakanaja
