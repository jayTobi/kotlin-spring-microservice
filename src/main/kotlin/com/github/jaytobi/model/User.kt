package com.github.jaytobi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.hateoas.ResourceSupport
import javax.persistence.*

/**
 * Simple domain model for an User.
 */
@Entity
@Table(name = "user")
data class User(@Id
                @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 10)
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq") val id: Long?,
                @Column(name = "name") var name: String,
                @Column(name = "e_mail") var email: String,
                @JsonIgnore @OneToMany(mappedBy = "user") var addresses: List<Address> = emptyList(),
                @JsonIgnore @OneToMany(mappedBy = "user") var accounts: List<Account> = emptyList()) : ResourceSupport()