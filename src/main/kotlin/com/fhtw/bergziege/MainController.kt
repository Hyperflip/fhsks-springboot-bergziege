package com.fhtw.bergziege

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    fun greetings(): String {
        return "index"
    }

    @GetMapping("/createArticle")
    fun getArticleForm(): String {
        return "createArticle"
    }
}