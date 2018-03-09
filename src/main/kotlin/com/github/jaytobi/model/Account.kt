package com.github.jaytobi.model

import org.springframework.hateoas.ResourceSupport
import javax.persistence.*

@Entity
@Table(name = "Account")
data class Account(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = 0,
                   @Column(length = 255) var description: String = "na",
                   @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") var user: User? = null) : ResourceSupport()
