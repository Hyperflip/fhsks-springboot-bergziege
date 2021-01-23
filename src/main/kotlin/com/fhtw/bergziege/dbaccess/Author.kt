package com.fhtw.bergziege.dbaccess

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity     // hibernate treats this class as a table of the database
data class Author(
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private val id: Int,

    private val name: String,
)