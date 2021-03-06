package com.fhtw.bergziege.author

import javax.persistence.*

@Entity     // hibernate treats this class as a table of the database
data class Author(
    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id")
    val id: Long? = null
)