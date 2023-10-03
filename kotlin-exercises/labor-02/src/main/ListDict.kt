package main
//1.feladat
class ListDict:IDictionary{
    private val words = mutableListOf<String>()

    //init{
    //File(IDictionary.DICTIONARY_NAME).forEachLine{words.add(it)
    //}
    init{
        words.add("alma")
        words.add("korte")
        words.add("szilva")
        words.add("cseresznye")
        words.add("szolo")
        words.add("paradicsom")
        words.add("paprika")
        words.add("krumpli")
        words.add("ribizli")
    }
    override fun add(word:String):Boolean{
        return words.add(word)
    }
}
