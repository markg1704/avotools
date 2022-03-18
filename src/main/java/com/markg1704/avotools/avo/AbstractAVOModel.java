package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public abstract class AbstractAVOModel {

    private final Layer layerA;
    private final Layer layerB;


    protected AVOToolBox getToolBox() {
        return AVOToolBox.getInstance();
    }

    protected double getPVelocity() {
        return (layerB.getPVelocity() + layerA.getPVelocity()) / 2;
    }

    protected double getSVelocity() {
        return (layerB.getSVelocity() + layerA.getSVelocity()) / 2;
    }

    protected double getDensity() {
        return (layerB.getDensity() + layerA.getDensity()) / 2;
    }

    protected double getDeltaP() {
        return layerB.getPVelocity() - layerA.getPVelocity();
    }

    protected double getDeltaS() {
        return layerB.getSVelocity() - layerA.getSVelocity();
    }

    protected double getDeltaDensity() {
        return layerB.getDensity() - layerA.getDensity();
    }

    protected double getRZero() {
        return 0.5 * ((getDeltaP()/getPVelocity()) + (getDeltaDensity()/getDensity()));
    }

    public abstract Map<Integer, Double> computeResponse();

}
