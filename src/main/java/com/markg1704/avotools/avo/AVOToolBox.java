package com.markg1704.avotools.avo;

import com.markg1704.avotools.datamodel.Layer;
import org.apache.commons.math3.util.Precision;

public final class AVOToolBox {

    private static AVOToolBox instance;

    private AVOToolBox() {
        // private constructor
    }

    public static AVOToolBox getInstance() {
        if (instance == null) {
            instance = new AVOToolBox();
        }

        return instance;
    }

    public double getPoissonRatio(final Layer layer) {
        return Precision.round((Math.pow(layer.getPVelocity(), 2) - (2 * Math.pow(layer.getSVelocity(), 2))) /
                (2 * (Math.pow(layer.getPVelocity(), 2) - Math.pow(layer.getSVelocity(),2))), 3);
    }


}
