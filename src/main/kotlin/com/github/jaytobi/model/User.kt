package com.github.jaytobi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.hateoas.ResourceSupport
import javax.persistence.*

/**
 * Simple domain model for an User.
 */
@Entity
@Table(name = "user")
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
                var name: String,
                var eMail: String,
                @JsonIgnore @OneToMany(mappedBy = "user") var addresses: List<Address> = emptyList(),
                @JsonIgnore @OneToMany(mappedBy = "user") var accounts: List<Account> = emptyList()) : ResourceSupport()