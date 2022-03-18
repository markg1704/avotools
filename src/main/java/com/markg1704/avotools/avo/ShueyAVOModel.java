package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;

import java.util.Map;

public class ShueyAVOModel extends AbstractAVOModel {

    public ShueyAVOModel(Layer layerA, Layer layerB) {
        super(layerA, layerB);
    }

    @Override
    public Map<Integer, Double> computeResponse() {
        return null;
    }

    private double getPoissonRatio() {
        return (getToolBox().getPoissonRatio(getLayerB()) + getToolBox().getPoissonRatio(getLayerA())) / 2;
    }

    private double getPoissonDelta() {
        return getToolBox().getPoissonRatio(getLayerB()) - getToolBox().getPoissonRatio(getLayerA());
    }
    private double getE() {
        return 0d; //getF() - 2 * (1 + getF()) *()
    }

    private double getF() {
        return (getDeltaP()/getPVelocity()) / ((getDeltaP()/getPVelocity()) + (getDeltaDensity()/getDensity()));
    }

}
