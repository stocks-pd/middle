package com.example.API

import java.io.File
import java.io.BufferedReader

fun main(args: Array<String>) {
    val lineList = mutableListOf<String>()

    File("C:/Users/oneti/Desktop/Contracts/favors_post/Received data.json").useLines { lines -> lines.forEach { lineList.add(it) }}
     lineList.forEach { println(">  " + it) }

}