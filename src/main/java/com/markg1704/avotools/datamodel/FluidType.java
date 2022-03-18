package com.markg1704.avotools.datamodel;

public enum FluidType {

    WATER("Water"),
    OIL("Oil"),
    GAS("Gas"),
    UNDEFINED("Undefined");

    private final String descriptor;

    FluidType(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public static FluidType getFluidTypeFromDescriptor(String value) {

        for (FluidType type : FluidType.values()) {
            if (value.equalsIgnoreCase(type.getDescriptor()))
                return type;
        }

        return null;
    }
}
