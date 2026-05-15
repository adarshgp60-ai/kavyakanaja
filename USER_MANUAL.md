# User Manual

## App Name

Kavya-Kanaja

## Purpose

Kavya-Kanaja helps users read, explore, understand, and save Kannada poems in a modern Android app.

## Requirements

- Android Studio
- Android emulator or Android phone
- Android SDK installed

## How To Build

```powershell
cd "D:\cursor file\Kavya kanaja mind matrix"
.\gradlew.bat :app:assembleDebug --no-daemon --max-workers=1
```

## How To Install

Start an emulator or connect a phone with USB debugging enabled, then run:

```powershell
.\gradlew.bat :app:installDebug --no-daemon --max-workers=1
```

## How To Open

Open the app drawer on the emulator/phone and tap:

```text
Kavya-Kanaja
```

Or launch with ADB:

```powershell
& "$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe" shell monkey -p com.kavyakanaja -c android.intent.category.LAUNCHER 1
```

## Main User Flow

1. Splash screen appears.
2. User completes onboarding or skips it.
3. User logs in, signs up, or continues as guest.
4. User lands on Home dashboard.
5. User opens poem of the day or selects a poem from Library/Explore.
6. User taps words for meaning, generates AI summary, or asks Kavya AI.
7. User saves favorite poems.
8. User checks progress and achievements in Profile.

## Features For Demo

- Browse 50 sample poems.
- Explore 10 poet profiles.
- Use favorites.
- Use AI-style summary and word explanation.
- Toggle dark mode.
- Adjust font size.
- View progress stats and achievement badges.
