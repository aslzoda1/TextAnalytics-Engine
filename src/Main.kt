import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("📝 Smart Text Analyzer Pro-ga xush kelibsiz!")
    println("Tahlil qilish uchun matnni kiriting (tugatish uchun yangi qatorda 'END' deb yozing):")

    val fullText = StringBuilder()
    while (true) {
        val line = scanner.nextLine()
        if (line == "END") break
        fullText.append(line).append(" ")
    }

    val analyzer = TextAnalyzer(fullText.toString())

    println("\n--- 📈 TAHLIL NATIJALARI ---")
    println("🔢 Jami so'zlar: ${analyzer.getWordCount()}")
    println("🔡 Simvollar (bo'shliqlarsiz): ${analyzer.getCharCountExcludingSpaces()}")
    println("📏 O'rtacha so'z uzunligi: ${"%.2f".format(analyzer.getAverageWordLength())} belgi")

    println("\n🔑 TOP 5 KALIT SO'ZLAR:")
    analyzer.getTopKeywords().forEach { (word, count) ->
        println(" - $word: $count marta")
    }
    println("--------------------------")
}