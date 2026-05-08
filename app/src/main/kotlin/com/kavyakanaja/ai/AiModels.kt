package com.kavyakanaja.ai

data class WordMeaning(
    val word: String,
    val simpleKannada: String,
    val english: String,
    val pronunciation: String,
    val usage: String
)

data class PoemAnalysis(
    val summary: String,
    val emotionalTone: String,
    val literaryAnalysis: String,
    val moralMessage: String
)
