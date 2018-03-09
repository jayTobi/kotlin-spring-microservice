package com.github.jaytobi.service

import com.github.jaytobi.model.Account

interface AccountService {
    fun findByUserId(userId: Long): List<Account>
}