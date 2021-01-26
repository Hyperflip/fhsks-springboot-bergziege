package com.fhtw.bergziege.article

import com.fhtw.bergziege.author.Author
import org.springframework.data.repository.CrudRepository

public interface ArticleRepository : CrudRepository<Article, Long> {
    fun findByLandmarkId(landmarkId: Long): List<Article>
}