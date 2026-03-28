class TextAnalyzer(private val text: String) {

     fun getWordCount(): Int {
        if (text.isBlank()) return 0
        return text.trim().split("\\s+".toRegex()).size
    }

     fun getCharCountExcludingSpaces(): Int {
        return text.replace("\\s".toRegex(), "").length
    }

     fun getTopKeywords(limit: Int = 5): List<Pair<String, Int>> {
        val stopWords = setOf("va", "bilan", "uchun", "ham", "esa", "is", "the", "a", "an", "in") // Keraksiz so'zlar
        val words = text.lowercase()
            .replace("[^a-zA-Zа-яА-Я0-9\\s]".toRegex(), "") // Tinish belgilarini olib tashlash
            .split("\\s+".toRegex())
            .filter { it.length > 2 && it !in stopWords }

        return words.groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .take(limit)
    }

     fun getAverageWordLength(): Double {
        val words = text.trim().split("\\s+".toRegex())
        if (words.isEmpty()) return 0.0
        return words.sumOf { it.length }.toDouble() / words.size
    }
}