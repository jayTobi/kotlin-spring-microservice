package com.github.jaytobi.service

import com.github.jaytobi.model.Address

/**
 * Service interface for accessing [Address]es.
 */
interface AddressService {
    /**
     * Searching for [Address]es that contain the provided parameters.
     *
     * @param street Street of the address, use % for wildcard search
     * @param city City of the address, use % for wildcard search
     * @param country Country of the address, use % for wildcard search
     * @return A list of [Address]es matching the criteria OR an empty list
     */
    fun findByDetails(street: String, city: String, country: String): List<Address>
}