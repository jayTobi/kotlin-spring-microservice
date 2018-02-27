package com.github.jaytobi.repo

import com.github.jaytobi.model.User
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional


@Transactional(Transactional.TxType.REQUIRED)
interface UserRepository : CrudRepository<User, Long>