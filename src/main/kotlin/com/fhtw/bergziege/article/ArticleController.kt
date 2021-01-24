package com.fhtw.bergziege.article

import com.fhtw.bergziege.author.Author
import com.fhtw.bergziege.author.AuthorRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/articles")
public class ArticleController constructor (
    private val articleRepository: ArticleRepository,
    private val authorRepository: AuthorRepository
) {

    @PostMapping("/add")
    @ResponseBody
    private fun addArticle(
        @RequestParam title: String,
        @RequestParam content: String,
        @RequestParam authorName: String
    ): String {
        // find author's id by name and take the first result
        val author: Author = authorRepository.findByName(authorName)[0]

        val article: Article = Article(title, content, author)
        articleRepository.save(article)

        return "Saved article '$title'"
    }

}