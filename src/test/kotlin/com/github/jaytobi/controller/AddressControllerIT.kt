package com.github.jaytobi.controller

import org.flywaydb.test.FlywayTestExecutionListener
import org.flywaydb.test.annotation.FlywayTest
import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import kotlin.test.assertEquals


/**
 * Simple integration test sample that could be used as blue print.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.yml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener::class,
        FlywayTestExecutionListener::class)
class AddressControllerIT {
    @Autowired
    lateinit var addressController: AddressController

    @Value("\${application.address.default.city}")
    lateinit var defaultCity: String


    @Test
    @FlywayTest(locationsForMigrate = ["dbtest/migration"])
    fun integrationTesting() {
        val addresses = addressController.getAddresses("%", "%", "%")
        assertEquals(3, addresses.size)
    }
}