package com.kavyakanaja.data

import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet

object SampleData {
    val poets = listOf(
        Poet("kuvempu", "ಕುವೆಂಪು", "ರಾಷ್ಟ್ರಕವಿ ಕುವೆಂಪು ಅವರು ವಿಶ್ವಮಾನವ ತತ್ವದ ಮೂಲಕ ಕನ್ನಡ ಸಾಹಿತ್ಯಕ್ಕೆ ಆಧುನಿಕ ಗೌರವ ತಂದರು.", awards = "Jnanpith, Padma Vibhushan", era = "Modern", jnanpithInfo = "1967ರಲ್ಲಿ ರಾಮಾಯಣ ದರ್ಶನಂ ಕೃತಿಗೆ ಜ್ಞಾನಪೀಠ.", influence = "ವಿಶ್ವಮಾನವ ಸಂದೇಶ ಮತ್ತು ನವೋದಯ ಸಾಹಿತ್ಯದ ಪ್ರಮುಖ ಧ್ವನಿ."),
        Poet("bendre", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಅಂಬಿಕಾತನಯದತ್ತ ಎಂಬ ಕಾವ್ಯನಾಮದಿಂದ ಕನ್ನಡ ಕಾವ್ಯಕ್ಕೆ ಸಂಗೀತಮಯ ಭಾವ ನೀಡಿದವರು.", awards = "Jnanpith", era = "Navodaya", jnanpithInfo = "1973ರಲ್ಲಿ ನಾಕುತಂತಿ ಕೃತಿಗೆ ಜ್ಞಾನಪೀಠ.", influence = "ಜನಪದ ಸೊಗಡು ಮತ್ತು ಆತ್ಮಾನುಭವದ ಸಂಯೋಜನೆ."),
        Poet("akkamahadevi", "ಅಕ್ಕ ಮಹಾದೇವಿ", "ವಚನ ಸಾಹಿತ್ಯದ ದಿಟ್ಟ ಸ್ತ್ರೀಸ್ವರ. ಚೆನ್ನಮಲ್ಲಿಕಾರ್ಜುನನ ಭಕ್ತಿಯು ಅವರ ವಚನಗಳಲ್ಲಿ ಹೊಳೆಯುತ್ತದೆ.", awards = "Vachana tradition", era = "Medieval", influence = "ಆಧ್ಯಾತ್ಮಿಕ ಸ್ವಾತಂತ್ರ್ಯ ಮತ್ತು ಸ್ತ್ರೀ ಚಿಂತನೆ."),
        Poet("basavanna", "ಬಸವಣ್ಣ", "ಸಾಮಾಜಿಕ ಸಮಾನತೆ ಮತ್ತು ಕಾಯಕ ತತ್ವವನ್ನು ವಚನಗಳ ಮೂಲಕ ಜನಮಾನಸಕ್ಕೆ ತಂದ ಶರಣ.", awards = "Vachana tradition", era = "Medieval", influence = "ಸಮಾನತೆ, ಕಾಯಕ, ದಾಸೋಹದ ನವಚಿಂತನೆ."),
        Poet("kanakadasa", "ಕನಕದಾಸ", "ಭಕ್ತಿ ಸಾಹಿತ್ಯದ ಶ್ರೇಷ್ಠ ಕವಿ. ಕೀರ್ತನೆಗಳ ಮೂಲಕ ಮಾನವೀಯತೆ ಸಾರಿದರು.", awards = "Haridasa tradition", era = "Bhakti", influence = "ಭಕ್ತಿ, ನೀತಿ ಮತ್ತು ಸಮಾಜಜಾಗೃತಿ."),
        Poet("purandaradasa", "ಪುರಂದರ ದಾಸ", "ಕರ್ನಾಟಕ ಸಂಗೀತದ ಪಿತಾಮಹ. ದೇವರನಾಮಗಳ ಮೂಲಕ ಭಕ್ತಿಯನ್ನು ಜನರಿಗೆ ಹತ್ತಿರ ಮಾಡಿದರು.", awards = "Haridasa tradition", era = "Bhakti", influence = "ಸಂಗೀತ ಶಿಕ್ಷಣ ಮತ್ತು ಭಕ್ತಿ ಸಾಹಿತ್ಯದ ನೆಲೆ."),
        Poet("masti", "ಮಾಸ್ತಿ ವೆಂಕಟೇಶ ಐಯಂಗಾರ್", "ಸಣ್ಣಕಥೆಗಳ ಜನಕರೆಂದು ಹೆಸರಾಗಿರುವ ಮಾಸ್ತಿ, ಕಾವ್ಯ ಮತ್ತು ಕಾದಂಬರಿಗಳಲ್ಲಿಯೂ ಮಹತ್ವದ ಕೊಡುಗೆ ನೀಡಿದರು.", awards = "Jnanpith", era = "Modern", jnanpithInfo = "1983ರಲ್ಲಿ ಚಿಕ್ಕವೀರ ರಾಜೇಂದ್ರ ಕೃತಿಗೆ ಜ್ಞಾನಪೀಠ.", influence = "ಮಾನವ ಸ್ವಭಾವದ ಸೂಕ್ಷ್ಮ ಚಿತ್ರಣ."),
        Poet("gs_shivarudrappa", "ಜಿ.ಎಸ್. ಶಿವರುದ್ರಪ್ಪ", "ಭಾವಗೀತೆ ಮತ್ತು ವಿಮರ್ಶೆಯಲ್ಲಿ ಪ್ರಸಿದ್ಧರಾದ ರಾಷ್ಟ್ರಕವಿ.", awards = "Rashtrakavi", era = "Modern", influence = "ಪ್ರೀತಿ, ಪ್ರಕೃತಿ ಮತ್ತು ಮಾನವೀಯ ಮೌಲ್ಯಗಳು."),
        Poet("ks_narasimhaswamy", "ಕೆ.ಎಸ್. ನರಸಿಂಹಸ್ವಾಮಿ", "ಮೈಸೂರು ಮಲ್ಲಿಗೆ ಮೂಲಕ ಗೃಹಜೀವನದ ಸೌಂದರ್ಯವನ್ನು ಕಾವ್ಯಗೊಳಿಸಿದವರು.", awards = "Sahitya Akademi", era = "Navodaya", influence = "ಸರಳ ಪ್ರೇಮಕಾವ್ಯದ ಜನಪ್ರಿಯ ಧ್ವನಿ."),
        Poet("pampa", "ಆದಿಕವಿ ಪಂಪ", "ಕನ್ನಡದ ಆದಿಕವಿ. ವಿಕ್ರಮಾರ್ಜುನ ವಿಜಯದ ಮೂಲಕ ಮಹಾಕಾವ್ಯ ಪರಂಪರೆಯನ್ನು ಬೆಳೆಸಿದರು.", awards = "Classical canon", era = "Classical", influence = "ಚಂಪೂ ಕಾವ್ಯದ ಶ್ರೇಷ್ಠ ಮಾದರಿ.")
    )

    private val categories = listOf("Bhakti", "Nature", "Love", "Philosophy", "Patriotism", "Classical Kannada")

    val poems: List<Poem> = (1..50).map { index ->
        val poet = poets[index % poets.size]
        val category = categories[index % categories.size]
        Poem(
            id = "poem_$index",
            title = when (index) {
                1 -> "ಬಾರಿಸು ಕನ್ನಡ ಡಿಂಡಿಮವ"
                2 -> "ನಾಕುತಂತಿಯ ನಾದ"
                3 -> "ಕಾಯಕವೇ ಕೈಲಾಸ"
                else -> "ಕನ್ನಡ ಕವನ $index"
            },
            poetId = poet.id,
            content = """
                ಕನ್ನಡದ ಮಣ್ಣಲ್ಲಿ ಬೆಳಕು ಮೂಡಿದೆ,
                ಪದಗಳ ಹಾದಿಯಲ್ಲಿ ಮನಸು ಹಾಡಿದೆ.
                ನದಿ, ನೆಲ, ಗಾಳಿ ನಮ್ಮ ನೆನಪು,
                ಕಾವ್ಯದೊಳಗೆ ಬದುಕಿನ ಕನಸು.
            """.trimIndent(),
            category = category,
            meaning = "ಈ ಕವನವು ಕನ್ನಡ ನಾಡಿನ ಸೌಂದರ್ಯ, ಭಾಷೆಯ ಹೆಮ್ಮೆ ಮತ್ತು ಮಾನವೀಯ ಕನಸನ್ನು ಸರಳವಾಗಿ ಹೇಳುತ್ತದೆ.",
            audioUrl = "asset:///audio/sample_recitation_$index.mp3",
            imageUrl = "https://picsum.photos/seed/kavya$index/600/400",
            difficultyLevel = (index % 5) + 1,
            dateAdded = 1_700_000_000_000L + index
        )
    }
}
