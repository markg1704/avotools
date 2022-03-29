package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;
import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ShueyAVOModelTest {

    @Test
    public void someTest() {
        Layer layerA = new Layer();

        layerA.setPVelocity(3.24);
        layerA.setSVelocity(1.62);
        layerA.setDensity(2.34);
        Layer layerB = new Layer();
        layerB.setPVelocity(2.59);
        layerB.setSVelocity(1.06);
        layerB.setDensity(2.21);

        ShueyAVOModel sut = new ShueyAVOModel(layerA, layerB);

        Map<Integer, Double> reflectivity = sut.computeResponse();

        for (Integer i : reflectivity.keySet()) {
            System.out.println("Angle " + i + " - RPP: " + Precision.round(reflectivity.get(i), 4));
        }

    }
}
