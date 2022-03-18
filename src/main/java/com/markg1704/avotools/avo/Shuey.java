package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;
import lombok.Data;

@Data
public class Shuey {

    private final Layer layerA;
    private final Layer layerB;

    private double getPVelocity() {
        return (layerB.getPVelocity() + layerA.getPVelocity()) / 2;
    }

    private double getSVelocity() {
        return (layerB.getSVelocity() + layerA.getSVelocity()) / 2;
    }

    private double getDensity() {
        return (layerB.getDensity() + layerA.getDensity()) / 2;
    }

    private double getDeltaP() {
        return layerB.getPVelocity() - layerA.getPVelocity();
    }

    private double getDeltaDensity() {
        return layerB.getDensity() - layerA.getDensity();
    }

    private double getDeltaS() {
        return layerB.getSVelocity() - layerA.getSVelocity();
    }

}
