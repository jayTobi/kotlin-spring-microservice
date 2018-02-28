package com.github.jaytobi.service

import com.github.jaytobi.model.User
import java.util.*

/**
 * Service interface for accessing [User]s.
 */
interface UserService {
    /**
     * Search a [User] by its unique id.
     * @return An Optional containing the possible user.
     */
    fun find(id: Long): Optional<User>?

    /**
     * Search for all [User]s.
     * @return A list of [User]s OR an empty list.
     */
    fun findAll(): List<User>

    /**
     * Save a [User].
     * @return The saved user, sometimes with additional information, like an id if it was newly created.
     */
    fun save(user: User): User?

    /**
     * Delete a [User].
     */
    fun delete(user: User)

    /**
     * Delete a [User] by its id (unique identifier).
     */
    fun deleteById(id: Long)
}