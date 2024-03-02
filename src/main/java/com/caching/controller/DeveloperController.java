package com.caching.controller;

import com.caching.constants.CachingConstants;
import com.caching.entity.Developer;
import com.caching.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping("/getAllDeveloper")
    public ResponseEntity<Object> getAllDevelopers() {
        List<Developer> developers = developerService.getAllDevelopers();
        if(developers != null)
            return new ResponseEntity<>(developers, HttpStatus.OK);
        else
            throw new RuntimeException(CachingConstants.INTERNAL_SERVER_ERROR);
    }
}
