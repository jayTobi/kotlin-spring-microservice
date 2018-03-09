package com.github.jaytobi.service

import com.github.jaytobi.model.Account
import com.github.jaytobi.repo.AccountRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
class AccountServiceImpl(val accountRepo: AccountRepository) : AccountService {
    override fun findByUserId(userId: Long): List<Account> {
        return accountRepo.findByUserId(userId)
    }
}