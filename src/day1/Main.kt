package day1

import java.io.File

fun main() {

    val input = readFileAsLinesUsingReadLines("src/day1/input")
    println(partOne(input))
    println(parTwo(input))
}


fun partOne(input: List<String>): Int {
    var lastNum = 0
    var increase = 0

    for (i in input) {
        if (i.toInt() > lastNum) {
            increase++
        }
        lastNum = i.toInt()
    }
    return increase - 1
}

fun parTwo(input: List<String>): Int {
    var actualNum = 0
    var lastNum = 0
    var output = 0

    for(i in input.indices){
        if(i < input.size-3){
            for(j in -1..1){
                actualNum += if(i <= 0) input[i].toInt()
                else input[i+j].toInt()
            }
        }
        if(actualNum > lastNum){
            output++
        }
        lastNum = actualNum
        actualNum = 0
    }
    return output
}


fun readFileAsLinesUsingReadLines(fileName: String): List<String> = File(fileName).readLines()