package com.markg1704.avotools.services;

import com.markg1704.avotools.datamodel.Layer;

import java.util.Map;
import java.util.Optional;

public interface ShueyAVOService {

    Optional<Map<Integer, Double>> getShuey(Layer layerA, Layer layerB);

}
