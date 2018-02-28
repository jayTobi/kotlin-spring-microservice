package com.github.jaytobi.repo

import com.github.jaytobi.model.User
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

/**
 * Spring Data repository for [User] model.
 */
@Transactional(Transactional.TxType.REQUIRED)
interface UserRepository : CrudRepository<User, Long>
//no additional methods are needed here - everything we need is provided in CrudRepository, e.g. find,, deleteById, save
//and due to Spring Data runtime weaving - we do not even need to provide an implementation