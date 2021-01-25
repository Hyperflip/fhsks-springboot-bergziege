package com.fhtw.bergziege.landmark

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/landmark")
public class LandmarkController constructor (
    private val landmarkRepository: LandmarkRepository
) {

    // TODO: finish routing CRUD for DB

    @PostMapping("/add")
    @ResponseBody
    public fun addNewLandmark(@RequestParam name: String): String {
        val landmark: Landmark = Landmark(name)

        landmarkRepository.save(landmark)

        return "Saved landmark $name"
    }

}