package com.markg1704.avotools.datamodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FluidTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"Water", "Oil", "Gas", "Undefined"})
    public void shouldReturnFluidTypeWhenDescriptorProvided(String value) {

        FluidType fluidType = FluidType.getFluidTypeFromDescriptor(value);

        assertNotNull(fluidType);

        FluidType comparison = getFluidTypeFromParameter(value);
        assertEquals(fluidType, comparison);

    }

    @Test
    public void shouldReturnUndefinedWhenUnrecognisedDescriptorProvided() {
        FluidType fluidType = FluidType.getFluidTypeFromDescriptor("nosuch");

        assertEquals(fluidType, FluidType.UNDEFINED);
    }

    private FluidType getFluidTypeFromParameter(String value) {

        switch (value) {
            case "Water":
                return FluidType.WATER;
            case "Oil":
                return FluidType.OIL;
            case "Gas":
                return FluidType.GAS;
            case "Undefined":
                return FluidType.UNDEFINED;
            default:
                return null;
        }

    }
}
