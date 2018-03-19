package com.github.jaytobi.controller

import com.github.jaytobi.model.Address
import com.github.jaytobi.service.AddressService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

/**
 * REST controller providing access to the [Address] resource.
 */
@RestController
@RequestMapping("/api/v1/addresses")
class AddressController(val addressService: AddressService) {
    val log: Logger = LoggerFactory.getLogger(AddressController::class.java)

    /**
     * Method for getting addresses.
     *
     * Optional request parameters (in URL with /api/v1/addresses/?city=Foo&country=Bar&street=bla)
     * can be provided in any combination to narrow down the results.
     *
     */
    @GetMapping("/", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun getAddresses(@RequestParam(name = "street", required = false, defaultValue = "%") street: String,
                     @RequestParam(name = "city", required = false, defaultValue = "%") city: String,
                     @RequestParam(name = "country", required = false, defaultValue = "%") country: String
    ): List<Address> {
        log.debug("searching for addresses using the following details street: '{}', city: '{}', country: '{}'", street, city, country)
        return addressService.findByDetails(street, city, country)
//        return addressService.findByDetails(street = street, city = city, country = country) //with named parameters (name = value) so you could omit some
    }
}