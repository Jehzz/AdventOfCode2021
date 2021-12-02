package day2

import java.io.File

fun main() {
    val inputFile = File("src/main/kotlin/day2/Day2Input.txt")

    println("Running Day 2 challenge")
    println("Part 1")
    val position = calculatePositionPart1(Position(0, 0), inputFile)
    println("Depth: ${position.depth} \nHorizontal distance: ${position.horizontal}")
    println("Puzzle answer: ${position.depth * position.horizontal}")

    println("Part 2")
    val position2 = calculatePositionPart2(Position(0, 0), inputFile)
    println("Depth: ${position2.depth} \nHorizontal distance: ${position2.horizontal}")
    println("Puzzle answer: ${position2.depth * position2.horizontal}\n")
}

fun calculatePositionPart1(inputPosition: Position, file: File): Position {
    val forwardRegex = Regex(pattern = "^forward")
    val downRegex = Regex(pattern = "^down")
    val upRegex = Regex(pattern = "^up")

    file.readLines().forEach { instruction ->
        when {
            forwardRegex.containsMatchIn(instruction) -> {
                inputPosition.horizontal += instruction.filter { it.isDigit() }.toInt()
            }
            upRegex.containsMatchIn(instruction) -> {
                inputPosition.depth -= instruction.filter { it.isDigit() }.toInt()
            }
            downRegex.containsMatchIn(instruction) -> {
                inputPosition.depth += instruction.filter { it.isDigit() }.toInt()
            }
        }
    }
    return inputPosition
}

fun calculatePositionPart2(inputPosition: Position, file: File): Position {
    val forwardRegex = Regex(pattern = "^forward")
    val downRegex = Regex(pattern = "^down")
    val upRegex = Regex(pattern = "^up")

    file.readLines().forEach { instruction ->
        when {
            forwardRegex.containsMatchIn(instruction) -> {
                instruction.filter { it.isDigit() }.toInt().apply {
                    inputPosition.horizontal += this
                    inputPosition.depth += this * inputPosition.aim
                }
            }
            upRegex.containsMatchIn(instruction) -> {
                inputPosition.aim -= instruction.filter { it.isDigit() }.toInt()
            }
            downRegex.containsMatchIn(instruction) -> {
                inputPosition.aim += instruction.filter { it.isDigit() }.toInt()

            }
        }
    }
    return inputPosition
}

data class Position(
    var horizontal: Int = 0,
    var depth: Int = 0,
    var aim: Int = 0
)