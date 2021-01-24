package com.fhtw.bergziege.author

import javax.persistence.*

@Entity     // hibernate treats this class as a table of the database
data class Author(
    private var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id")
    var id: Long? = null
)