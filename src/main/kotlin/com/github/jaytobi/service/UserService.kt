package com.github.jaytobi.service

import com.github.jaytobi.model.User
import java.util.*

/**
 * Interface for accessing users.
 */
interface UserService {

    fun find(id: Long): Optional<User>?

    fun findAll(): List<User>

    fun save(user: User): User?

    fun delete(user: User)

    fun deleteById(id: Long): Unit
}