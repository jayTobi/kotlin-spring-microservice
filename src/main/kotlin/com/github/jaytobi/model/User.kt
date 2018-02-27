package com.github.jaytobi.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long?,
                var name: String,
                var eMail: String)
