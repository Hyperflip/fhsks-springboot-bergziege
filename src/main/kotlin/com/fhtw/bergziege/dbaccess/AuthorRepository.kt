package com.fhtw.bergziege.dbaccess

import org.springframework.data.repository.CrudRepository

// auto implemented by Spring, turns into a "Bean" called authorRepository
public interface AuthorRepository : CrudRepository<Author, Integer> {

}