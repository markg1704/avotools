package com.markg1704.avotools.datamodel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Project {

    @GeneratedValue
    @Id
    private Long id;

    private String name;
}
