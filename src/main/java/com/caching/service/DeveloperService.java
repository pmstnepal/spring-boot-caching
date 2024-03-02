package com.caching.service;

import com.caching.entity.Developer;
import com.caching.repository.DeveloperRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class DeveloperService {
    private final DeveloperRepo developerRepo;

    /**
     * READ operation for Developer
     * @return
     */
    public List<Developer> getAllDevelopers() {
        try {
            List<Developer> developers = developerRepo.findAll();
            Thread.sleep(3000); // Added sleep call to increase the normal execution time
            log.info("Developers List: {}", developers.toString());
            return developers;
        } catch (Exception e) {
            log.error("Exception occurred while fetching all developers: {},{}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * GET by ID operation for Developer
     * @return
     */
    public Developer getById(Long id) {
        try {
            Optional<Developer> developer = developerRepo.findById(id);
            Thread.sleep(3000); // Added sleep call to increase the normal execution time
            log.info("Developer with Id: {} is : {}", id, developer.get().toString());
            return developer.get();
        } catch (Exception e) {
            log.error("Exception occurred while fetching developer by id: {},{}", e.getMessage(), e);
        }
        return null;
    }
}
