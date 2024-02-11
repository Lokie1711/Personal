package com.inter.backend.service;

import com.inter.backend.entity.EntityClass;
import com.inter.backend.repo.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ServiceClass {

    @Autowired
    Repository repository;
    public EntityClass updateById(Long id, EntityClass entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            entity.setCity_name(entity.getCity_name());
            repository.save(entity);
        } else {
            log.info("No data present :( ");
        }
        return entity;
    }

    public List<EntityClass> updateByCity(String city, EntityClass entity) {
        EntityClass exampleEntity = new EntityClass();
        exampleEntity.setCity_name(city);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("city_name", ExampleMatcher.GenericPropertyMatcher::ignoreCase);

        Example<EntityClass> example = Example.of(exampleEntity, matcher);

        List<EntityClass> matchingEntities = repository.findAll(example);

        if (!matchingEntities.isEmpty()) {
            for (EntityClass existingEntity : matchingEntities) {
                existingEntity.setCity_name(entity.getCity_name());
                repository.save(existingEntity);
            }
            return matchingEntities;
        } else {
            log.info("No data present for city: " + city);
            return Collections.emptyList();
        }
    }
}
