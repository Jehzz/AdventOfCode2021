package day1

import java.io.File

fun main() {
    println("Running Day 1 challenge")
    val inputFile = File("src/main/kotlin/day1/Day1Input.txt")

    val numOfIncreases = calculateIncreases(inputFile)
    println("Part 1 Solution = $numOfIncreases")
    val threeWindowIncreases = calculateIncreases(inputFile, 3)
    println("Part 2 solution = $threeWindowIncreases")
}

fun calculateIncreases(file: File, window: Int = 1): Int {
    var counter = 0
    var a: Int
    var b : Int
    val lines = file.readLines()
    for (line in 0 until lines.size-window) {
        a = lines[line].toInt()
        b = lines[line+window].toInt()
        if ( b > a ) counter++
    }
    return counter
}