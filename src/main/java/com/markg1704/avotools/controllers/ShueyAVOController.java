package com.markg1704.avotools.controllers;

import com.markg1704.avotools.datamodel.LayerModelDTO;
import com.markg1704.avotools.services.ShueyAVOService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/shuey")
@AllArgsConstructor
public class ShueyAVOController {

    private ShueyAVOService service;

    @PostMapping("/model")
    public ResponseEntity<Map<Integer, Double>> getShueyResponse(@RequestBody LayerModelDTO model) {
        return ResponseEntity.of(service.getShuey(model.getLayerA(), model.getLayerB()));
    }
}
