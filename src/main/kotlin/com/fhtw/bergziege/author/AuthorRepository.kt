package com.fhtw.bergziege.author

import org.springframework.data.repository.CrudRepository

// auto implemented by Spring, turns into a "Bean" called authorRepository
public interface AuthorRepository : CrudRepository<Author, Integer> {
    public fun findByName(name: String): List<Author>
}