package com.example.demo.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoController {
    @RequestMapping("/echo/{text}/{count}")
    fun echo(
            @PathVariable("text") text: String,
            @PathVariable("count") count: Int): String {
        var str = ""
        repeat(count) {
            str += "$text "
        }
        return str
    }
}