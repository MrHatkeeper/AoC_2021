package day2


import java.io.File

fun main(){

    val input = readFileAsLinesUsingReadLines("src/day2/input")
    println(partOne(input))
    println(partTwo(input))


}

fun partOne(input: List<String>): Int {
    var forward = 0
    var height = 0


    for(i in input){
        val actual = i.split(" ")

        if(actual[0] == "forward"){
            forward += actual[1].toInt()
        }
        else if(actual[0] == "down"){
            height += actual[1].toInt()
        }
        else if(actual[0] == "up"){
            height -= actual[1].toInt()
        }
    }

    return forward * height
}

fun partTwo(input: List<String>): Int{
    var forward = 0
    var depth = 0
    var aim = 0


    for(i in input){
        val actual = i.split(" ")

        if(actual[0] == "forward"){
            forward += actual[1].toInt()
            depth += aim * actual[1].toInt()
        }
        else if(actual[0] == "down"){
            aim += actual[1].toInt()
        }
        else if(actual[0] == "up"){
            aim -= actual[1].toInt()
        }

        println(actual)
        println("$forward $depth $aim")
    }

    return forward * depth
}





fun readFileAsLinesUsingReadLines(fileName: String): List<String> = File(fileName).readLines()