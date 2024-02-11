package com.inter.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "interview_geography_columns")
@Data
public class EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String city_name;
    private String websites;

}
