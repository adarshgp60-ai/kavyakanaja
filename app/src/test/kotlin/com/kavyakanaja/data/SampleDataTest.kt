package com.kavyakanaja.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SampleDataTest {
    @Test
    fun sampleData_hasRequiredMvpVolume() {
        assertTrue(SampleData.poems.size >= 50)
        assertTrue(SampleData.poets.size >= 10)
        assertEquals(6, SampleData.poems.map { it.category }.distinct().size)
    }
}
