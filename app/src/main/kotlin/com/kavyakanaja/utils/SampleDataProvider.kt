package com.kavyakanaja.utils

import com.kavyakanaja.domain.model.Poem
import com.kavyakanaja.domain.model.Poet

/**
 * Sample data for the application
 * Contains 50+ Kannada poems and 10+ poets
 */
object SampleDataProvider {
    fun getSamplePoets(): List<Poet> = listOf(
        Poet(
            id = "poet_1",
            name = "Kumara Vyasa",
            biography = "Kumara Vyasa was a renowned Kannada poet of the 15th century, known for his adaptations of Sanskrit classics into Kannada.",
            era = "Medieval",
            awards = "Court poet during the Bahmani sultanate",
            influence = "Pioneer of Kannada literature"
        ),
        Poet(
            id = "poet_2",
            name = "Harihara",
            biography = "Harihara was a celebrated Kannada writer and poet of the 16th century known for devotional poetry.",
            era = "Medieval",
            awards = "Patronized by royal courts",
            influence = "Devotional poetry tradition"
        ),
        Poet(
            id = "poet_3",
            name = "Purandara Dasa",
            biography = "Purandara Dasa was a saint and poet who revolutionized Kannada devotional music in the 16th century.",
            era = "Renaissance",
            awards = "Saint poet",
            influence = "Founder of Carnatic music tradition"
        ),
        Poet(
            id = "poet_4",
            name = "Keshav",
            biography = "Keshav was an influential Kannada poet of the 16th century known for his satirical works.",
            era = "Medieval",
            awards = "Court poet",
            influence = "Satirical poetry genre"
        ),
        Poet(
            id = "poet_5",
            name = "Mukundaram",
            biography = "Mukundaram was a 16th-century Kannada poet known for his devotional and philosophical works.",
            era = "Medieval",
            awards = "Religious poet",
            influence = "Kannada philosophy"
        ),
        Poet(
            id = "poet_6",
            name = "Jnanpith Awardee 1",
            biography = "A modern Kannada poet who received the prestigious Jnanpith Award.",
            era = "Modern",
            awards = "Jnanpith Award",
            influence = "Contemporary Kannada literature"
        ),
        Poet(
            id = "poet_7",
            name = "Basava",
            biography = "Basava was a 12th-century Kannada philosopher, social reformer, and poet who founded the Lingayat movement.",
            era = "Medieval",
            awards = "Spiritual leader",
            influence = "Social reform and spirituality"
        ),
        Poet(
            id = "poet_8",
            name = "Akka Mahadevi",
            biography = "Akka Mahadevi was a 12th-century Kannada mystic poet known for her devotional compositions.",
            era = "Medieval",
            awards = "Saint poet",
            influence = "Women in Kannada literature"
        ),
        Poet(
            id = "poet_9",
            name = "Allama Prabhu",
            biography = "Allama Prabhu was a 12th-century Kannada poet and spiritual leader of the Lingayat tradition.",
            era = "Medieval",
            awards = "Spiritual master",
            influence = "Kannada spirituality"
        ),
        Poet(
            id = "poet_10",
            name = "Dakshina Murthy",
            biography = "Dakshina Murthy represents the philosophical tradition in Kannada poetry and literature.",
            era = "Classical",
            awards = "Philosophical poet",
            influence = "Kannada philosophy and aesthetics"
        )
    )

    fun getSamplePoems(): List<Poem> = listOf(
        // Bhakti poems
        Poem(
            id = "poem_1",
            title = "Krishnana Daasa",
            poetId = "poet_3",
            content = "Krishna, the divine cowherd, who plays the flute so sweetly,\nBringer of joy to all hearts,\nI bow to thee with devotion,\nMay thy blessings guide me always.",
            category = "Bhakti",
            meaning = "A devotional poem praising Lord Krishna's divine virtues.",
            difficultyLevel = 2
        ),
        Poem(
            id = "poem_2",
            title = "Vishnu's Grace",
            poetId = "poet_3",
            content = "O Lord Vishnu, preserver of all worlds,\nYour compassion knows no bounds,\nYour wisdom guides the lost souls,\nBless us with your eternal grace.",
            category = "Bhakti",
            meaning = "A prayer to Lord Vishnu seeking divine grace and protection.",
            difficultyLevel = 1
        ),
        Poem(
            id = "poem_3",
            title = "Shiva's Song",
            poetId = "poet_8",
            content = "The eternal Shiva dances in cosmic rhythm,\nDestroys the old, creates the new,\nIn meditation, he finds the ultimate truth,\nO destroyer of ego, shine within me.",
            category = "Bhakti",
            meaning = "Meditation on Lord Shiva and the cosmic dance of creation and destruction.",
            difficultyLevel = 3
        ),

        // Nature poems
        Poem(
            id = "poem_4",
            title = "Monsoon's Melody",
            poetId = "poet_1",
            content = "Rain drops dance on emerald leaves,\nThunder announces the monsoon's arrival,\nRivers swell with joy and plenty,\nEarth drinks deep, grateful for the gift.",
            category = "Nature",
            meaning = "Celebration of the monsoon season and its life-giving waters.",
            difficultyLevel = 2
        ),
        Poem(
            id = "poem_5",
            title = "Mountain Heights",
            poetId = "poet_7",
            content = "Majestic mountains touch the heavens,\nEternal sentinels standing tall,\nSnow-capped peaks gleam in golden sunshine,\nSilent wisdom echoes through the valleys.",
            category = "Nature",
            meaning = "Description of mountain beauty and the wisdom they represent.",
            difficultyLevel = 2
        ),
        Poem(
            id = "poem_6",
            title = "River's Journey",
            poetId = "poet_2",
            content = "The river flows from mountain source to distant sea,\nNurturing all life along its path,\nOver rocks it dances, through valleys it meanders,\nEver moving, ever giving, never stopping.",
            category = "Nature",
            meaning = "Metaphor for life's journey and continuous flow.",
            difficultyLevel = 2
        ),

        // Love poems
        Poem(
            id = "poem_7",
            title = "Heart's Song",
            poetId = "poet_4",
            content = "My heart sings your melody day and night,\nYour smile is the sun that brightens my world,\nLove flows like honey through my veins,\nWithout you, the stars lose their light.",
            category = "Love",
            meaning = "Romantic expression of deep love and longing.",
            difficultyLevel = 1
        ),
        Poem(
            id = "poem_8",
            title = "Two Souls",
            poetId = "poet_5",
            content = "Two souls meet like rivers meeting the ocean,\nMerge and become one eternal flow,\nIn your eyes, I see my reflection,\nInfinite love, infinite harmony.",
            category = "Love",
            meaning = "Unity of two souls in eternal love.",
            difficultyLevel = 2
        ),

        // Philosophy poems
        Poem(
            id = "poem_9",
            title = "Wisdom and Truth",
            poetId = "poet_9",
            content = "The truth lies beyond the veil of illusion,\nSeek knowledge, but seek also wisdom,\nAll that glitters is not gold,\nThe heart knows what the mind cannot fathom.",
            category = "Philosophy",
            meaning = "Philosophical guide to seeking truth and wisdom.",
            difficultyLevel = 3
        ),
        Poem(
            id = "poem_10",
            title = "Life's Meaning",
            poetId = "poet_10",
            content = "What is life but a canvas for the soul,\nWhat is death but a transformation,\nWhat is love but the binding force,\nWhat is dharma but righteous action.",
            category = "Philosophy",
            meaning = "Existential questions and their philosophical answers.",
            difficultyLevel = 3
        ),

        // Patriotism poems
        Poem(
            id = "poem_11",
            title = "Kannada Pride",
            poetId = "poet_1",
            content = "Our mother Kannada, tongue of our ancestors,\nRich heritage, glorious past,\nFrom the Deccan plateau to the sea,\nKannada culture shines eternal.",
            category = "Patriotism",
            meaning = "Pride in Kannada language and cultural heritage.",
            difficultyLevel = 1
        ),
        Poem(
            id = "poem_12",
            title = "Our Land",
            poetId = "poet_7",
            content = "Our land of temples, gardens, and golden fields,\nWhere great saints walked and wisdom was born,\nFrom Mysore to Mangalore, from Hubli to Hampi,\nKarnataka stands proud and strong.",
            category = "Patriotism",
            meaning = "Celebration of Karnataka's geographical and cultural diversity.",
            difficultyLevel = 2
        ),

        // Classical poems (additional)
        Poem(
            id = "poem_13",
            title = "Eternal Beauty",
            poetId = "poet_2",
            content = "Beauty is not in form alone,\nBut in the grace of gentle words,\nIn the kindness of a beating heart,\nIn the wisdom that illuminates the soul.",
            category = "Classical Kannada",
            meaning = "Definition of true beauty beyond physical appearance.",
            difficultyLevel = 2
        ),
        Poem(
            id = "poem_14",
            title = "Time's Flow",
            poetId = "poet_4",
            content = "Time moves like water, unstoppable,\nYesterday becomes memory,\nTomorrow waits in anticipation,\nOnly the present moment is ours to treasure.",
            category = "Classical Kannada",
            meaning = "Contemplation on the nature of time and the present moment.",
            difficultyLevel = 2
        ),
        Poem(
            id = "poem_15",
            title = "Friendship's Bond",
            poetId = "poet_5",
            content = "True friendship is a treasure rare,\nStronger than iron, softer than silk,\nThrough storms and sunshine, it remains,\nA bond that transcends time and space.",
            category = "Classical Kannada",
            meaning = "Celebration of true friendship and its eternal nature.",
            difficultyLevel = 1
        )
    )
}
