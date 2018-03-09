package com.github.jaytobi.model

import javax.persistence.*

/**
 * Simple domain model for an address.
 */
@Entity
@Table(name = "address")
data class Address(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
                   @Column(length = 255) var street: String,
                   @Column(length = 255) var city: String,
                   @Column(length = 255) var country: String,
                   @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") var user: User? = null)