package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.transaction.Transactional

@RestController
class UserController (
        private val repository: UserRepository // @AutowiredをつけなくてもKotlinなら勝手にDIされる
){
    @RequestMapping(path = ["/users"], method = [RequestMethod.GET])
    @Transactional
    fun getAll(): List<User> {
        return repository.findAll()
    }

    @RequestMapping(path = ["/users/{id}"], method = [RequestMethod.GET])
    fun get(@PathVariable("id") id: Int): User {
        return repository.findById(id).orElse(null)
    }

    @RequestMapping(path = ["/users"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): User {
        return repository.save(user)
    }

    @RequestMapping(path = ["/users/{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable("id") id: Int, @RequestBody user: User): User {
        user.id = id
        return repository.save(user)
    }

    @RequestMapping(path = ["/users/{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable("id") id: Int) {
        repository.deleteById(id)
    }
}