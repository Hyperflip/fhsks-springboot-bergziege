package com.fhtw.bergziege

import com.fhtw.bergziege.routing.MainController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BergziegeApplication

fun main(args: Array<String>) {
    runApplication<BergziegeApplication>(*args)
}
