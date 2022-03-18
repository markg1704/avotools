package com.markg1704.avotools.datamodel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Layer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private FluidType fluidType;

    private double pVelocity;
    private double sVelocity;
    private double density;

}
