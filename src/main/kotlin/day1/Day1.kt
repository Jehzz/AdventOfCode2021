package day1

import java.io.File

fun main() {
    println("Running Day 1 challenge")
    val inputFile = File("src/main/kotlin/day1/Day1Input.txt")

    val numOfIncreases = calculateIncreases(inputFile)
    println("Part 1 Solution = $numOfIncreases")
    val threeWindowIncreases = calculateThreeWindowIncreases(inputFile)
    println("Part 2 solution = $threeWindowIncreases")
}

fun calculateIncreases(file: File): Int {
    var counter = 0
    var a: Int
    var b : Int
    val lines = file.readLines()
    for (line in 0 until lines.size-1) {
        a = lines[line].toInt()
        b = lines[line+1].toInt()
        if ( b > a ) counter++
    }
    return counter
}

fun calculateThreeWindowIncreases(file: File): Int {
    var counter = 0
    var a: Int
    var d: Int
    val lines = file.readLines()
    for (line in 0 until lines.size-3) {
        a = lines[line].toInt()
        d = lines[line+3].toInt()
        if ( d > a ) counter++
    }
    return counter
}