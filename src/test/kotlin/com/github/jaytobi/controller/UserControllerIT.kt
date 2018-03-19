package com.github.jaytobi.controller

import com.github.jaytobi.ExampleApplication
import org.junit.jupiter.api.Assertions.*
import com.github.jaytobi.config.AppConfig
import com.github.jaytobi.model.User
import org.flywaydb.test.FlywayTestExecutionListener
import org.flywaydb.test.annotation.FlywayTest
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.context.WebApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener


@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [AppConfig::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ExampleApplication::class])
@TestPropertySource("classpath:application.yml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener::class,
        FlywayTestExecutionListener::class)
class UserControllerIT {
    @Autowired
    lateinit var wac: WebApplicationContext

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun verifyEnv() {
        val servletContext = wac.servletContext
        assertNotNull(servletContext);
        assertNotNull(wac.getBean("userController"));
    }

    @Test
    @FlywayTest(locationsForMigrate = ["dbtest/migration"])
    fun getAddressForUser() {
        val user = testRestTemplate.getForObject("/api/v1/users/1", User::class.java, emptyMap<Object, Object>())
        println(user)
        assertEquals("jon@doe.com", user.email)
        assertEquals(1L, user.id)
        assertEquals("Jon Doe", user.name)
    }

    @Test
    @FlywayTest(locationsForMigrate = ["dbtest/migration"])
    fun getAddresses() {
        val user = testRestTemplate.getForObject("/api/v1/users/", Array<User>::class.java, emptyMap<Object, Object>())
        assertEquals(1, user.size)
    }
}