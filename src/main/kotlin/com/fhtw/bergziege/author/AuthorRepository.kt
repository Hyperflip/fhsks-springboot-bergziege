package com.fhtw.bergziege.author

import org.springframework.data.repository.CrudRepository

// auto implemented by Spring, turns into a "Bean" called authorRepository
interface AuthorRepository : CrudRepository<Author, Long> {
    fun findByName(name: String): List<Author>
}