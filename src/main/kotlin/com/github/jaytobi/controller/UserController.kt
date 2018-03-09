package com.github.jaytobi.controller

import com.github.jaytobi.model.User
import com.github.jaytobi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * REST controller providing access to the [User] resource.
 */
@RestController()
@RequestMapping("/api/v1/users", produces = ["application/hal+json"])
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
     * @return Returns the [User] with the provided id.
     */
    @RequestMapping(value = "/{id}", method = [(RequestMethod.GET)]) //same as @GetMapping but more verbose
//    fun getUser(@PathVariable("id") id: Long) = userService.find(id)
    fun getUser(@PathVariable("id") id: Long): ResponseEntity<User> {
        val user = userService.find(id)!!.get()

        user.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserController::class.java).getUser(id)).withSelfRel())
        user.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserController::class.java).getUsers()).withRel("users"))
        if (user.accounts.isNotEmpty()) {
            user.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AccountController::class.java).getAccountsForUser(id)).withRel("accounts"))
        }
        //TODO remove addresses from user or model the resource as dependant resource with mapping /user/{id}/addresses

        return ResponseEntity(user, HttpStatus.OK)
    }

    /**
     * Method for deleting a specific user by id
     */
    @RequestMapping(value = "/{id}", method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.OK)
    fun deleteUser(@PathVariable("id") id: Long) = userService.deleteById(id)
}