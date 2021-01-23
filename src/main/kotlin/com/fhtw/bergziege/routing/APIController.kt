package com.fhtw.bergziege.routing

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api")
public class APIController {
    @GetMapping()
    @ResponseBody
    private fun greetings(): String {
        return "Hello API.";
    }

    // TODO: CRUD for DB
}