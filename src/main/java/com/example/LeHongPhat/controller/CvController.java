package com.example.LeHongPhat.controller;

import org.springframework.web.bind.annotation.*;
import com.example.LeHongPhat.model.Cv;
import com.example.LeHongPhat.service.CvService;

import java.util.List;

@RestController
@RequestMapping("/cv")
public class CvController {

    private final CvService service;

    public CvController(CvService service){
        this.service = service;
    }

    @PostMapping
    public Cv saveCv(@RequestBody Cv cv){
        return service.save(cv);
    }

    @GetMapping
    public List<Cv> getAllCv(){
        return service.getAll();
    }
}
