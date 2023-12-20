package main
import kotlin.random.Random
//<iframe src="https://pl.kotl.in/_1i7nvOpy"></iframe>
//https://pl.kotl.in/FJB_x3xs6
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
//package com.bezkoder.kotlin.base64

import java.util.Base64

//3.feladat

fun isPrime(num:Int):Boolean{
    var flag = false
    for (i in 2..num / 2) {
        // condition for nonprime number
        if (num % i == 0) {
            flag = true
            break
        }
    }
    //ha a flag true akkor prim ha false akkor nem prim
    return flag

}
//4.feladat
fun encode(s:String):String{
    return Base64.getEncoder().encodeToString(s.toByteArray())
}

fun decode(s:String):String{
    return String(Base64.getDecoder().decode(s))

}
//5. feladat
fun isEvenNumber(a:Int) = a%2 == 0


fun main() {
    //1.feladat
    println()
    println("1.feladat")
    println()
    val a = 2
    val b = 5
    val sum1 = a+b
    println("sum1 = $sum1")
    println("sum2 = ${3+5}")

    //2.feladat
    println()
    println("2.feladat")
    println()
    //het napjai lista
    val arr = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    //lista kiirasa
    for(day in arr){
        println(day)
    }
    println()
    //filter azokat a napokat irjuk ki amelyek T vel kezdodnek
    arr.filter{it.startsWith("T")}.forEach{println(it)}
    println()
    //filter azokat a napokat irjuk ki amelyekben e van
    arr.filter{it.contains("e")}.forEach{println(it)}
    println()
    //
    arr.filter{it.length==6}.forEach{println(it)}
    println()
    //3.feladat
    println()
    println("3.feladat")
    println()
    for(i in 1..100){
        var flag = isPrime(i)
        if (!flag)
            println("$i is a prime number.")
        // else
        // println("$i is not a prime number.")
    }

    //5.feladat
    println()
    println("5.feladat")
    println()
    var isEven = isEvenNumber(3)
    println(isEven)
    //5
    println(encode("was"))

    //ex. 6
    println()
    println("6.feladat")
    println()
    // Double the elements of a list of integers and print it.
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubledNumbers = numbers.map { it * 2 }
    println(doubledNumbers)

    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Print the days of the week capitalized
    val capitalizedDays = daysOfWeek.map { it.toUpperCase() }
    println(capitalizedDays)

    // Print the first character of each day capitalized
    val firstCharOfDays = daysOfWeek.map { it.first().toUpperCase().toString() }
    println(firstCharOfDays)

    // Print the length of days (number of characters)
    val dayLengths = daysOfWeek.map { it.length }
    println(dayLengths)

    // Compute the average length of days (in number of characters)
    val averageLength = dayLengths.average()
    println("Average day length: $averageLength")
    println("Average day length: $averageLength")


    println()
    println("7.feladat")
    println()
    // Create a mutable list
    val daysOfWeekMut = daysOfWeek.toMutableList();

    // Remove all days containing the letter 'n'.
    daysOfWeekMut.removeIf { it.contains('n') }

    // Print the mutable list.
    println(daysOfWeek)

    // Print each element of the list in a new line together with the index of the element.
    for ((index, day) in daysOfWeek.withIndex()) {
        println("Item at $index is $day")
    }

    //8.feladat

    println()
    println("8.feladat")
    println()

    // Generate an array of 10 random integers between 0 and 100
    val randomIntArray = IntArray(10) { Random.nextInt(0, 101) }

    // Use forEach to print each element of the array in a new line
    randomIntArray.forEach { println(it) }

    // Print the array sorted in ascending order
    val sortedArray = randomIntArray.sorted()
    println("Sorted array: $sortedArray")

    // Check whether the array contains any even number
    val containsEven = randomIntArray.any { it % 2 == 0 }
    println("Contains even number: $containsEven")

    // Check whether all the numbers are even
    val allEven = randomIntArray.all { it % 2 == 0 }
    println("All numbers are even: $allEven")

    // Calculate the average of generated numbers and print it using forEach
    val sum = randomIntArray.sum()
    val average = if (randomIntArray.isNotEmpty()) sum.toDouble() / randomIntArray.size else 0.0
    println("Average: $average")
}