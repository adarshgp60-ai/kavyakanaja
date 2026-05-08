package com.kavyakanaja.ai

import com.kavyakanaja.domain.model.Poem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalAiLiteratureClient @Inject constructor() : AiLiteratureClient {
    override suspend fun explainWord(word: String, poem: Poem): WordMeaning = WordMeaning(
        word = word,
        simpleKannada = "$word ಎಂದರೆ ಈ ಕವನದ ಸಂದರ್ಭದಲ್ಲಿ ಭಾವನೆ, ನೆನಪು ಅಥವಾ ಮೌಲ್ಯವನ್ನು ಸೂಚಿಸುವ ಪದ.",
        english = "$word is explained contextually as an image or emotion inside the poem.",
        pronunciation = word,
        usage = "$word ಎಂಬ ಪದವನ್ನು ಕವಿ ಮನದ ಸ್ಥಿತಿಯನ್ನು ತೋರಿಸಲು ಬಳಸುತ್ತಾರೆ."
    )

    override suspend fun analyzePoem(poem: Poem): PoemAnalysis = PoemAnalysis(
        summary = poem.meaning,
        emotionalTone = "Warm, reflective, and proud.",
        literaryAnalysis = "The poem uses simple imagery from land, river, voice, and memory to create cultural intimacy.",
        moralMessage = "Language and literature stay alive when a new generation reads, listens, and questions with love."
    )

    override suspend fun recommendPoems(category: String, mood: String): List<String> =
        listOf("poem_1", "poem_7", "poem_13", "poem_25").shuffled()

    override suspend fun chat(message: String): String =
        "Kavya AI: I can help with Kannada word meanings, poem summaries, poet history, and reading suggestions. You asked: $message"
}
