package com.markg1704.avotools.datamodel.dto;

import lombok.Value;

@Value
public class SimpleLayerDTO {

    private final Long id;
    private final String name;

    private final double pVelocity;
    private final double sVelocity;
    private final double density;

}
