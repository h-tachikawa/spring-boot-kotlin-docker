package com.example.demo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @RequestMapping("/hello")
    fun messageFunc(): String {
        return "Hello World"
    }
}