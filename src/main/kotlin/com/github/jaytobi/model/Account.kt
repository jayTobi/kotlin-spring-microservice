package com.github.jaytobi.model

import org.springframework.hateoas.ResourceSupport
import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(@Id
                   @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 10)
                   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq") val id: Long?,
                   @Column(length = 255) var description: String = "na",
                   @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") var user: User? = null) : ResourceSupport()
