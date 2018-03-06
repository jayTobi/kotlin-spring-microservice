package com.github.jaytobi.controller

import com.github.jaytobi.model.Address
import com.github.jaytobi.service.AddressService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito
import kotlin.test.assertEquals

/**
 * A simple unit test (JUnit 4) using Mockito to mock e.g. the Service layer
 */
@RunWith(MockitoJUnitRunner::class)
class AddressControllerTest {
    @InjectMocks
    lateinit var addressController: AddressController

    @Mock
    lateinit var addressService: AddressService

    @Before
    fun setUp() {
        //mocking the return value of the service
        val addresses = listOf(Address(1337, "Main street", "SF", "USA"))
        Mockito.`when`(addressService.findByDetails(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(addresses)
    }

    @Test
    fun findMockedAddresses() {
        val result = addressController.getAddresses("%", "%", "%")
        assertEquals(1, result.size)
    }
}