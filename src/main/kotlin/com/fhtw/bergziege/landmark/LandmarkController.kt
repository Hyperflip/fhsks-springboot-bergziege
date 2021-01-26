package com.fhtw.bergziege.landmark

import com.fhtw.bergziege.article.Article
import com.fhtw.bergziege.article.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/landmark")
public class LandmarkController constructor (
    private val landmarkRepository: LandmarkRepository,
    private val articleRepository: ArticleRepository
) {

    @PostMapping("/add")
    @ResponseBody
    fun addNewLandmark(@RequestParam name: String): String {
        val landmark: Landmark = Landmark(name)

        landmarkRepository.save(landmark)

        return "Saved landmark $name"
    }

    // get landmark view count per id
    @GetMapping()
    @ResponseBody
    fun getLandmarkViewCountById(@RequestParam id: Long): String {
        val landmark: Landmark = landmarkRepository.findById(id).get()
        val articles: List<Article> = articleRepository.findByLandmarkId(id)
        var sum: Int = 0
        articles.forEach { sum += it.viewCount }

        return "articles of landmark \"${landmark.name}\" have been viewed a total of $sum times"
    }
}