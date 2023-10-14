package main
import java.util.*

//ex. 2. Extension function
fun String.monogram():String = this.split(" ").map{it[0]}.joinToString("")

// Extension function to join strings in a list with a separator
fun List<String>.joinWithSeparator(separator: String): String {
    return joinToString(separator)
}

// Extension function to find the longest string in a list
fun List<String>.findLongestString(): String? {
    return maxByOrNull { it.length }
}


//Ex. 3. lab2.

data class Date(val year: Int, val month: Int, val day: Int) {
    constructor() : this(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
}

// Extension function to check if a year is a leap year
fun Date.isLeapYear(): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

// Extension function to check if a date is valid
fun Date.isValidDate(): Boolean {
    if (month in 1..12 && day in 1..31) {
        when (month) {
            4, 6, 9, 11 -> return day <= 30
            2 -> return if (isLeapYear()) day <= 29 else day <= 28
            else -> return true
        }
    }
    return false
}


fun main(args: Array<String>) {
    //println("Hello World!")
    //Ex. 2 lab2
    val name = "John Smith"
    println(name.monogram())
    println("Program arguments: ${args.joinToString()}")
    val fruits = listOf("apple", "pear", "strawberry", "melon")

    val joined = fruits.joinWithSeparator("#")
    println("Joined: $joined")

    val longest = fruits.findLongestString()
    println("Longest: $longest")


    //ex3 lab 2.

    val validDates = mutableListOf<Date>()
    val random = Random()

    while (validDates.size < 10) {
        val year = random.nextInt(1900)
        val month = random.nextInt(13)
        val day = random.nextInt(32)

        val date = Date(year, month, day)

        if (date.isValidDate()) {
            validDates.add(date)
        } else {
            println("Invalid Date: $date")
        }
    }

    println("Valid Dates:")
    validDates.forEach { println(it) }

    // Sort the list using natural ordering
    //validDates.sort()
    // Custom comparator to sort Date objects by year
    val yearComparator = Comparator<Date> { date1, date2 -> date1.year - date2.year }

    validDates.sortWith(yearComparator)

    println("\nSorted Dates:")
    validDates.forEach { println(it) }

    // Reverse the sorted list
    validDates.reverse()
    println("\nReversed Dates:")
    validDates.forEach { println(it) }

    // Sort the list using a custom ordering (by year)
    validDates.sortWith(compareBy { it.year })
    println("\nCustom Sorted Dates:")
    validDates.forEach { println(it) }
}