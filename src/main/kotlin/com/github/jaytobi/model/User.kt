package com.github.jaytobi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.ResourceSupport
import javax.persistence.*

/**
 * Simple domain model for an User.
 */
@Entity
@Table(name = "user")
data class User(@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 10)
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
                @Id @field:JsonProperty("id") var id: Long? = null,
                @Column(name = "name") var name: String = "",
                @Column(name = "e_mail") var email: String = "",
                @JsonIgnore @OneToMany(mappedBy = "user") var addresses: List<Address> = emptyList(),
                @JsonIgnore @OneToMany(mappedBy = "user") var accounts: List<Account> = emptyList()) : ResourceSupport()
// the id of this class needs special annotations because of the ResourceSupport to be serialized into the JSON
// for details see (if it's a good idea to use it like this is up to the reader
// https://github.com/spring-projects/spring-hateoas/issues/67
// https://github.com/FasterXML/jackson-module-kotlin/issues/98