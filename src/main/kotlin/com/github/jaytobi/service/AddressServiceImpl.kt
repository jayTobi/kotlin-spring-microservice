package com.github.jaytobi.service

import com.github.jaytobi.model.Address
import com.github.jaytobi.repo.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
class AddressServiceImpl @Autowired constructor(private val addressRepo: AddressRepository) : AddressService {
    override fun findByDetails(street: String, city: String, country: String) = addressRepo.findByStreetContainsAndCityContainsAndCountryContains(street, city, country)

    override fun findByUserId(userId: Long) = addressRepo.findByUserId(userId)
}
