package com.github.jaytobi.service

import com.github.jaytobi.model.User
import com.github.jaytobi.repo.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
class UserServiceImpl(val userRepo: UserRepository) : UserService {
    override fun find(id: Long): Optional<User> = userRepo.findById(id)

    override fun findAll(): List<User> = userRepo.findAll().toList()

    override fun save(user: User): User? = userRepo.save(user)

    override fun delete(user: User) = userRepo.delete(user)

    override fun deleteById(id: Long) = userRepo.deleteById(id)
}