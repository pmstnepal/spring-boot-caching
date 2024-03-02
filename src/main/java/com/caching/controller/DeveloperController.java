package com.caching.controller;

import com.caching.entity.Developer;
import com.caching.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService developerService;

    @GetMapping("/getAllDeveloper")
    @Cacheable(value = "developerCache")
    public List<Developer> getAllDevelopers() {
        long start = System.currentTimeMillis();
        log.info("Execution started: {}", start);
        List<Developer> developers = developerService.getAllDevelopers();
        log.info("Execution completed, cost: {} ms", (System.currentTimeMillis() - start));
        return developers;
    }
}
