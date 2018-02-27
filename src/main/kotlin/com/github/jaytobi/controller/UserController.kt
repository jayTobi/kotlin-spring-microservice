package com.github.jaytobi.controller

import com.github.jaytobi.model.User
import com.github.jaytobi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController()
@RequestMapping("/api/v1/users")
class UserController {
    // one of 3 possibilities to autowire dependencies using Spring
    @Autowired
    lateinit var userService: UserService

    /**
     * Method returning all [User]s.
     *
     * @return List<User> list of users or empty list.
     */
    @GetMapping("/")
    fun getUsers() = userService.findAll()

    /**
     * Returns the [User] with the provided id.
     * @return
     */
    @RequestMapping(value = "/{id}", method = [(RequestMethod.GET)]) //same as @GetMapping but more verbose
    fun getUser(@PathVariable("id") id: Long) = userService.find(id)

    @RequestMapping(value = "/{id}", method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteUser(@PathVariable("id") id: Long) = userService.deleteById(id)
}