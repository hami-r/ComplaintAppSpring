package com.nest.complaintapp_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplaintController {

    @GetMapping("/")
    public String home(){
        return "Welcome to the complaint api";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/useradd",consumes = "application/json",produces = "application/json")
    public String userReg(){
        return "user reg";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userverify",consumes = "application/json",produces = "application/json")
    public String userVerify(){
        return "user verify";
    }
}
