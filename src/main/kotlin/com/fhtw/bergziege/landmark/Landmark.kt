package com.fhtw.bergziege.landmark

import javax.persistence.*

@Entity     // hibernate treats this class as a table of the database
data class Landmark(
    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="landmark_id")
    val id: Long? = null
)