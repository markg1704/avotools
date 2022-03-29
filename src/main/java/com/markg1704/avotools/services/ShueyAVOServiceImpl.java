package com.markg1704.avotools.services;

import com.markg1704.avotools.avo.ShueyAVOModel;
import com.markg1704.avotools.datamodel.Layer;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ShueyAVOServiceImpl implements ShueyAVOService {

    @Override
    public Optional<Map<Integer, Double>> getShuey(Layer layerA, Layer layerB) {
        ShueyAVOModel model = new ShueyAVOModel(layerA, layerB);
        return Optional.of(model.computeResponse());
    }
}
