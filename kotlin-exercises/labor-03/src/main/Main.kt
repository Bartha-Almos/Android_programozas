package main
import java.util.*
import kotlin.random.Random.Default.nextInt
import kotlin.random.Random
import java.io.BufferedReader
import java.io.FileReader


data class item(
        val question: String,
        val answers: List<String>,
        val correct: Int
)

class Itemrepository(fileName: String){
    val items = mutableListOf<item>()
    val fileName = fileName

     init{
         var counter = 0
         var countItems = 0
         var q = ""
         var a = mutableListOf<String>()
        // var c = 0
         try {
             BufferedReader(FileReader(fileName)).use { reader ->
                 var line: String?
                 while (reader.readLine().also { line = it } != null) {
                     println(line)
                     counter++
                     if (counter == 1) {
                         q = line.toString()
                     } else if (counter in 2..5) {
                         a.add(line.toString())
                     } else if (counter == 6) {
                         val c = line.toString().toBigInteger()
                         val newItem = item(q, a, c.toInt() - 1)
                         items.add(newItem)
                         q = ""
                         a = mutableListOf()
                         counter = 0
                     }

                 }
             }
         } catch (e: Exception) {
             e.printStackTrace()
         }
     }

    fun randomItem(): item {

        if (items.isNotEmpty()) {
            val randomIndex = Random.nextInt(0, items.size)
            return items[randomIndex]
        }
        return items[0]
    }
    fun size():Int{
        return 0
    }
}

class ItemService(private val itemRepository: Itemrepository){
    fun selectRandomItems(numberOfItems: Int): List<item>{
        if(numberOfItems > itemRepository.size()){
            val randItems = mutableListOf<item>()
            for(i in 1..numberOfItems) {
                var randItem = itemRepository.randomItem()
                randItems.add(randItem)
            }
            return randItems
        }
        return emptyList()
    }
}

class ItemController(private val itemService: ItemService) {
    fun quiz(numberOfQuestions: Int) {
        val selectedItems = itemService.selectRandomItems(numberOfQuestions)
        var correctAnswers = 0

        for (item in selectedItems) {
            println(item.question)
            item.answers.forEachIndexed { index, answer ->
                println("${index + 1}. $answer")
            }

            print("Your answer: ")
            val userResponse = readLine()?.toIntOrNull()

            if (userResponse != null && userResponse - 1 == item.correct) {
                println("Correct!\n")
                correctAnswers++
            } else {
                println("Incorrect. The correct answer is ${item.correct + 1}.\n")
            }
        }

        println("Quiz result: $correctAnswers correct answers out of $numberOfQuestions")
    }
}

fun main(args: Array<String>) {
    //println("ye")

    val iR = Itemrepository("C:\\Users\\Egyetem\\Documents\\Android_programozas\\Android_programozas\\kotlin-exercises\\labor-03\\src\\main\\kerdesek_valaszok.txt")
    val itemService = ItemService(iR)
    val itemController = ItemController(itemService)

    val numberOfQuestions = 5 // Set the number of questions you want in the quiz
    itemController.quiz(numberOfQuestions)
}
