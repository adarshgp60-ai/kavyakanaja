package com.kavyakanaja.ai

import com.kavyakanaja.domain.model.Poem

interface AiLiteratureClient {
    suspend fun explainWord(word: String, poem: Poem): WordMeaning
    suspend fun analyzePoem(poem: Poem): PoemAnalysis
    suspend fun recommendPoems(category: String, mood: String): List<String>
    suspend fun chat(message: String): String
}
