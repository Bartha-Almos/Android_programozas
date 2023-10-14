//lab2 ex. 1.
import java.util.*
// // IDictionary interface
interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int
}

// ListDictionary class implementing IDictionary
class ListDictionary : IDictionary {
    private val wordsList = mutableListOf<String>()
    init{
        wordsList.add("alma")
        wordsList.add("korte")
        wordsList.add("szilva")
        wordsList.add("cseresznye")
        wordsList.add("szolo")
        wordsList.add("paradicsom")
        wordsList.add("paprika")
        wordsList.add("krumpli")
        wordsList.add("ribizli")

    }
    override fun add(word: String): Boolean {
        if (!find(word)) {
            wordsList.add(word)
            return true
        }
        return false
    }

    override fun find(word: String): Boolean {
        return wordsList.contains(word)
    }

    override fun size(): Int {
        return wordsList.size
    }
}

// DictionaryType enumeration
enum class DictionaryType {
    ARRAY_LIST, TREE_SET, HASH_SET
}

// TreeSetDictionary class implementing IDictionary
class TreeSetDictionary : IDictionary {
    private val wordsTreeSet = TreeSet<String>()
    init{
        wordsTreeSet.add("alma")
        wordsTreeSet.add("korte")
        wordsTreeSet.add("szilva")
        wordsTreeSet.add("cseresznye")
        wordsTreeSet.add("szolo")
    }
    override fun add(word: String): Boolean {
        return wordsTreeSet.add(word)
    }

    override fun find(word: String): Boolean {
        return wordsTreeSet.contains(word)
    }

    override fun size(): Int {
        return wordsTreeSet.size
    }
}

// HashSetDictionary class implementing IDictionary
class HashSetDictionary : IDictionary {
    private val wordsHashSet = HashSet<String>()
    init{
        wordsHashSet.add("alma")
        wordsHashSet.add("korte")
        wordsHashSet.add("szilva")
        wordsHashSet.add("cseresznye")
    }
    override fun add(word: String): Boolean {
        return wordsHashSet.add(word)
    }

    override fun find(word: String): Boolean {
        return wordsHashSet.contains(word)
    }

    override fun size(): Int {
        return wordsHashSet.size
    }
}

// DictionaryProvider utility class
object DictionaryProvider {
    fun createDictionary(type: DictionaryType): IDictionary {
        return when (type) {
            DictionaryType.ARRAY_LIST -> ListDictionary()
            DictionaryType.TREE_SET -> TreeSetDictionary()
            DictionaryType.HASH_SET -> HashSetDictionary()
        }
    }
}

fun main() {
    val dictType = DictionaryType.TREE_SET // Change this to the desired dictionary type
    val dict: IDictionary = DictionaryProvider.createDictionary(dictType)

    println("Number of words: ${dict.size()}")
    var word: String?
/* while (true) {
     print("What to find? ")
     word = readLine()
     if (word.equals("quit", ignoreCase = true)) {
         break
     }
     val result = word?.let { dict.find(it) }
     println("Result: $result")
 }*/
}