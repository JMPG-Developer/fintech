package es.jmpg.developer.fintech.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/status")
public class StatusController {

    @GetMapping("/")
    public String status(){
        return "OK";
    }

}
