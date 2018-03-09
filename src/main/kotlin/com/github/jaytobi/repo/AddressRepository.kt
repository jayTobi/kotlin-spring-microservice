package com.github.jaytobi.repo


import com.github.jaytobi.model.Address
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

/**
 * Spring Data repository for [Address] model.
 */
@Transactional(Transactional.TxType.REQUIRED)
interface AddressRepository : CrudRepository<Address, Long> {
    /**
     * Method for finding addresses. Using same Spring "magic", i.e. naming conventions, to create a query with all 3 model attributes,
     * searches for containing the value, no exact match but still case sensitive, and combines all sub-queries with AND.
     *
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     *
     * @return List<Address> a list of addresses or an empty list
     */
    fun findByStreetContainsAndCityContainsAndCountryContains(street: String, city: String, country: String): List<Address>

    fun findByUserId(userId : Long) : List<Address>
}