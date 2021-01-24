package com.fhtw.bergziege.article

import org.springframework.data.repository.CrudRepository

public interface ArticleRepository : CrudRepository<Article, Integer> {
}