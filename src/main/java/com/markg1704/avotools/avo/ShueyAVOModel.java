package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;

import java.util.HashMap;
import java.util.Map;

public class ShueyAVOModel extends AbstractAVOModel {

    private static final int MAX_ANGLE = 30;

    public ShueyAVOModel(Layer layerA, Layer layerB) {
        super(layerA, layerB);
    }

    @Override
    public Map<Integer, Double> computeResponse() {

        Map<Integer, Double> responseCurve = new HashMap<>();

        for (int i = 0; i <= MAX_ANGLE; i++) {
            double reflectivity = getRZero() + getBComponent(i) + getCComponent(i);
            responseCurve.put(i, reflectivity);
        }

        return responseCurve;
    }

    private double getBComponent(double angle) {
        return (getE() * getRZero() + (getPoissonDelta() / Math.pow(1 - getPoissonRatio(), 2))) * getSinSquared(angle);
    }

    private double getCComponent(double angle) {
        return 0.5 * (getDeltaP()/getPVelocity()) *(getTanSquared(angle) - getSinSquared(angle));
    }

    private double getSinSquared(double angle) {
        return Math.pow(Math.sin(Math.toRadians(angle)), 2);
    }

    private double getTanSquared(double angle) {
        return Math.pow(Math.tan(Math.toRadians(angle)), 2);
    }

    private double getPoissonRatio() {
        return (getToolBox().getPoissonRatio(getLayerB()) + getToolBox().getPoissonRatio(getLayerA())) / 2;
    }

    private double getPoissonDelta() {
        return getToolBox().getPoissonRatio(getLayerB()) - getToolBox().getPoissonRatio(getLayerA());
    }
    private double getE() {
        return getF() - 2 * (1 + getF()) *((1 - 2 * getPoissonRatio()) / (1 - getPoissonRatio()));
    }

    private double getF() {
        return (getDeltaP()/getPVelocity()) / ((getDeltaP()/getPVelocity()) + (getDeltaDensity()/getDensity()));
    }

}
