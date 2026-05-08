package com.kavyakanaja.ai

import com.kavyakanaja.domain.model.Poem
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class LocalAiLiteratureClientTest {
    private val client = LocalAiLiteratureClient()

    @Test
    fun analyzePoem_returnsSummaryToneAndMessage() = runTest {
        val poem = Poem(
            id = "test",
            title = "Test Poem",
            poetId = "poet",
            content = "ಕನ್ನಡದ ಬೆಳಕು",
            category = "Patriotism",
            meaning = "A poem about Kannada pride."
        )

        val analysis = client.analyzePoem(poem)

        assertTrue(analysis.summary.contains("Kannada"))
        assertTrue(analysis.emotionalTone.isNotBlank())
        assertTrue(analysis.moralMessage.isNotBlank())
    }
}
