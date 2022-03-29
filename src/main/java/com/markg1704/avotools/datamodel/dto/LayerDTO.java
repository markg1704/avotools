package com.markg1704.avotools.datamodel.dto;

import com.markg1704.avotools.datamodel.FluidType;
import com.markg1704.avotools.datamodel.RockType;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class LayerDTO {

    private Long id;

    private String well;
    private String name;
    private Long projectId;

    private String fluidType;
    private String rockType;

    private double pVelocity;
    private double sVelocity;
    private double density;

    public FluidType getFluidType() {
        if (fluidType == null)
            return FluidType.UNDEFINED;

        return FluidType.getFluidTypeFromDescriptor(fluidType);
    }

    public RockType getRockType() {
        if (rockType == null)
            return RockType.UNDEFINED;

        return RockType.getRockTypeFromDescriptor(rockType);
    }

}
