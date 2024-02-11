package com.inter.backend.repo;

import com.inter.backend.entity.EntityClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repository extends JpaRepository<EntityClass, Long> {
    @Query("SELECT e FROM EntityClass e WHERE e.city_name = :cityName")
    List<EntityClass> findByCityName(@Param("cityName") String cityName);

    @Query(value = "SELECT * FROM interview_geography_columns WHERE websites = :webName", nativeQuery = true)
    List<EntityClass> findByWebsite(@Param("webName") String webName);
}
