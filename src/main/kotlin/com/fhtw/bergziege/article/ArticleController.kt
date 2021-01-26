package com.fhtw.bergziege.article

import com.fhtw.bergziege.author.Author
import com.fhtw.bergziege.author.AuthorRepository
import com.fhtw.bergziege.landmark.Landmark
import com.fhtw.bergziege.landmark.LandmarkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/api/article")
public class ArticleController constructor (
    private val articleRepository: ArticleRepository,
    private val authorRepository: AuthorRepository,
    private val landMarkRepository: LandmarkRepository,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Long>
) {

    @PostMapping("/add")
    @ResponseBody
    private fun addArticle(
        @RequestParam title: String,
        @RequestParam authorName: String,
        @RequestParam landmarkName: String,
        @RequestParam content: String
    ): String {
        // find author's id by name and take the first result
        val author: Author = authorRepository.findByName(authorName)[0]
        // same with landmark
        val landmark: Landmark = landMarkRepository.findByName(landmarkName)[0]

        val article: Article = Article(title, content, 0, landmark, author)
        articleRepository.save(article)

        return "Saved article '$title'"
    }

    @GetMapping("/all")
    fun getAllArticles(model: Model): String {
        model.addAttribute("articles", articleRepository.findAll())

        return "dashboard"
    }

    // get article by id
    @GetMapping()
    fun getArticleById(@RequestParam id: Long, model: Model): String {
        var article: Article = articleRepository.findById(id).get()
        var authorId: Long = article.author!!.id!!
        var landmarkId: Long = article.landmark!!.id!!

        var author: Author = authorRepository.findById(authorId).get()
        var landmark: Landmark = landMarkRepository.findById(landmarkId).get()

        article.viewCount++
        articleRepository.save(article)

        model.addAttribute("article", article)
        model.addAttribute("author", author.name)
        model.addAttribute("landmark", landmark.name)

        // send kafka message
        kafkaTemplate.send("payment", authorId)

        return "articleView"
    }

}