package com.fhtw.bergziege

import com.fhtw.bergziege.landmark.Landmark
import com.fhtw.bergziege.landmark.LandmarkRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
public class MainController(
    val landmarkRepository: LandmarkRepository
) {

    @GetMapping()
    fun greetings(model: Model): String {

        val landmarks: ArrayList<Landmark> = ArrayList()
        landmarkRepository.findAll().forEach {
            landmarks.add(it)
        }

        model.addAttribute("landmarks", landmarks)

        return "index"
    }

    @GetMapping("/createArticle")
    fun getArticleForm(): String {
        return "createArticle"
    }
}