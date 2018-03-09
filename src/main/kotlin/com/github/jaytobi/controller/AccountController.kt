package com.github.jaytobi.controller

import com.github.jaytobi.service.AccountService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users/{userId}/accounts")
class AccountController(val accountService: AccountService) {
    @RequestMapping("/")
    fun getAccountsForUser(@PathVariable("userId") userId: Long) = accountService.findByUserId(userId);

}