package com.fhtw.bergziege.author

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/author")
public class AuthorController constructor (
    private val authorRepository: AuthorRepository
) {

    // TODO: finish routing CRUD for DB

    @PostMapping("/add")
    @ResponseBody
    fun addNewAuthor(@RequestParam name: String): String {
        val author: Author = Author(name)

        authorRepository.save(author)

        return "Saved author $name"
    }

    // TODO: return each authors payment stats
    @GetMapping()
    fun getAuthorStatsById(@RequestParam id: Long, model: Model): String {
        return ""
    }


}