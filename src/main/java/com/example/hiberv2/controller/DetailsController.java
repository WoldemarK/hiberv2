package com.example.hiberv2.controller;

import com.example.hiberv2.model.Details;
import com.example.hiberv2.service.DetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/d")
@RequiredArgsConstructor
public class DetailsController {
    private final DetailsService serviceD;

    @PostMapping
    public void createDetails(@RequestBody Details details){
        serviceD.addingDetails(details);
    }
}
