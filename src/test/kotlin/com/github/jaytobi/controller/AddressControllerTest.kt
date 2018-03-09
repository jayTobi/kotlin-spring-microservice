package com.github.jaytobi.controller

import com.github.jaytobi.model.Address
import com.github.jaytobi.service.AddressService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * A simple unit test using Mockito to mock e.g. the Service layer
 */
// @ExtendWith(MockitoExtension::class)  //would make MockitoAnnotations.initMocks(this) obsolete
// @RunWith(JUnitPlatform::class)
class AddressControllerTest {
    @InjectMocks
    lateinit var addressController: AddressController

    @Mock
    lateinit var addressService: AddressService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        // manual boiler plate until MockitoExtension is released then we could use @ExtendWith(MockitoExtension::class):
        // https://github.com/junit-team/junit5-samples/tree/master/junit5-mockito-extension
        //mocking the return value of the service
        val addresses = listOf(Address(1337, "Main street", "SF", "USA"))
        Mockito.`when`(addressService.findByDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(addresses)
    }

    @Test
    fun findMockedAddresses() {
        val result = addressController.getAddresses("%", "%", "%")
        assertEquals(1, result.size)
        assertEquals("Main street", result[0].street)
    }

    @Test
    fun `exception testing`() { //better naming with kotlin
        //asserting a method call throws an exception -> we use a simple 'lambda' to directly throw it
        val exception = assertThrows<IllegalArgumentException>("Should throw an exception") {
            throw IllegalArgumentException("a message")
        }
        assertEquals("a message", exception.message)
    }
}