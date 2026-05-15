# Test Plan

## Build Verification

| Test | Expected Result |
| --- | --- |
| Run `.\gradlew.bat :app:assembleDebug --no-daemon --max-workers=1` | APK builds successfully |
| Run `.\gradlew.bat :app:installDebug --no-daemon --max-workers=1` with emulator running | App installs successfully |
| Launch from app drawer | Kavya-Kanaja opens |

## Functional Test Cases

| ID | Test Case | Steps | Expected Result |
| --- | --- | --- | --- |
| TC-01 | Splash navigation | Open app | Splash appears and navigates to onboarding/home |
| TC-02 | Onboarding | Tap Next through onboarding | User reaches auth screen |
| TC-03 | Guest login | Tap Continue as Guest | User reaches home dashboard |
| TC-04 | Home content | View home screen | Poem of the day, categories, progress, challenge, poets appear |
| TC-05 | Library | Tap Library tab | Poem list appears |
| TC-06 | Explore search | Search a poem/category | Filtered poems appear |
| TC-07 | Poem detail | Open any poem | Full poem and actions appear |
| TC-08 | Word meaning | Tap poem word | Meaning bottom sheet appears |
| TC-09 | AI summary | Tap Generate Poem Analysis | Summary card appears |
| TC-10 | Kavya AI chat | Open Ask Kavya AI and ask question | Local AI response appears |
| TC-11 | Favorite poem | Tap bookmark | Poem is saved in favorites |
| TC-12 | Poet corner | Open poet list | Poet biographies appear |
| TC-13 | Profile settings | Toggle dark mode and font size | UI updates setting state |
| TC-14 | App icon | Install app | Kavya-Kanaja icon appears in launcher |

## Known Demo Limitations

- AI is local fallback, not cloud connected.
- Authentication is placeholder UI.
- Audio controller is architecture-ready; real recitation files should be added for production.
- Sample content should be replaced with curated licensed/public-domain content for final publishing.
