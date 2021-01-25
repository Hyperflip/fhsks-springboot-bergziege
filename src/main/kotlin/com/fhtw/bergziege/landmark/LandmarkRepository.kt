package com.fhtw.bergziege.landmark

import org.springframework.data.repository.CrudRepository

interface LandmarkRepository : CrudRepository<Landmark, Long> {
    public fun findByName(name: String): List<Landmark>
}