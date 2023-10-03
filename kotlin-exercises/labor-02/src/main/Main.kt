package main





/*
//1.feladat
class DicitionaryProvider{
    companion object {
        fun createDictionary(type: DictionaryType): IDictionary{
            when(type){
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.TREE_SET -> TreesetDictionary
                DictionaryType.HASH_SET -> HashDictionary
            }
        }
    }
}*/

//2.feladat Extension function
fun String.monogram():String = this.split(" ").map{it[0]}.joinToString("")

//3.feladatppp

fun main(args: Array<String>) {
    println("Hello World!")
    val name = "John Smith"
    println(name.monogram())
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}