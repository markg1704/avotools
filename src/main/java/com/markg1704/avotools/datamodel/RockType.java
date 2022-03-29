package com.markg1704.avotools.datamodel;

public enum RockType {

    SAND("Sand"),
    SHALE("Shale"),
    LIMESTONE("Limestone"),
    UNDEFINED("Undefined");

    private final String descriptor;

    RockType(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public static RockType getRockTypeFromDescriptor(String value) {

        for (RockType type : RockType.values()) {
            if (value.equalsIgnoreCase(type.getDescriptor()))
                return type;
        }

        return RockType.UNDEFINED;
    }

}
