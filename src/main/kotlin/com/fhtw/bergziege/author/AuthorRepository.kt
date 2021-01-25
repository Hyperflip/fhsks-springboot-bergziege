package com.fhtw.bergziege.author

import org.springframework.data.repository.CrudRepository

// auto implemented by Spring, turns into a "Bean" called authorRepository
public interface AuthorRepository : CrudRepository<Author, Long> {
    public fun findByName(name: String): List<Author>
}