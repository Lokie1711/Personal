package com.inter.backend.controller;

import com.inter.backend.entity.EntityClass;
import com.inter.backend.repo.Repository;
import com.inter.backend.service.ServiceClass;
import com.inter.backend.service.WebsiteChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class ControllerClass {

    private final WebsiteChecker websiteChecker;

    @Autowired
    private ServiceClass service;
    @Autowired
    Repository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public List<EntityClass> getAllData() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getById/{id}")
    public Optional<EntityClass> getGeographyById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateById/{id}")
    public EntityClass updateById(@PathVariable Long id, @RequestBody EntityClass entity) {
        return service.updateById(id, entity);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateByCity/{city}")
    public List<EntityClass> updateByCity(@PathVariable String city, @RequestBody EntityClass entity) {
        return service.updateByCity(city, entity);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getByName/{cityName}")
    public List<EntityClass> getByCityName(@PathVariable String cityName) {
        return repository.findByCityName(cityName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/status")
    public String getWebsiteStatus() {
        String status = websiteChecker.checkWebsiteStatus() ? "SUCCESS" : "FAILURE";
        return "Website status: " + status;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/status/{webName}")
    public List<EntityClass> getWebsite(@PathVariable String webName) {
        return repository.findByWebsite(webName);
    }
}