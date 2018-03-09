package com.github.jaytobi.repo

import com.github.jaytobi.model.Account
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

@Transactional(Transactional.TxType.REQUIRED)
interface AccountRepository : CrudRepository<Account, Long> {
    fun findByUserId(userId: Long): List<Account>
}