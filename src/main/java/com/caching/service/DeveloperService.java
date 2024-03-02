package com.caching.service;

import com.caching.entity.Developer;
import com.caching.repository.DeveloperRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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
            Thread.sleep(5000); // Added sleep call to increase the normal execution time
            log.info("Developers List: {}", developers.toString());
            return developers;
        } catch (Exception e) {
            log.error("Exception occurred while fetching all developers: {},{}", e.getMessage(), e);
        }
        return null;
    }
}
