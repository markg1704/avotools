package com.markg1704.avotools.controllers;

import com.markg1704.avotools.datamodel.FluidType;
import com.markg1704.avotools.datamodel.RockType;
import com.markg1704.avotools.datamodel.dto.LayerDTO;
import com.markg1704.avotools.services.LayerService;
import com.markg1704.avotools.web.Endpoints;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.LAYER)
@AllArgsConstructor
public class LayerController {

    private final LayerService layerService;

    @GetMapping(Endpoints.GET)
    public ResponseEntity<Iterable<LayerDTO>> getLayers() {
        return ResponseEntity.of(layerService.getLayers());
    }

    @PostMapping(Endpoints.CREATE)
    public ResponseEntity<LayerDTO> createLayer(@RequestBody LayerDTO layer) {
        return ResponseEntity.of(layerService.createLayer(layer));
    }

    @GetMapping(Endpoints.GET_BY_WELL)
    public ResponseEntity<Iterable<LayerDTO>> getLayersByWell(@RequestParam("well") String well) {
        return ResponseEntity.of(layerService.getLayersByWell(well));
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<LayerDTO> getLayerById(@RequestParam("id") Long id) {
        return ResponseEntity.of(layerService.getLayerById(id));
    }

    @GetMapping(Endpoints.GET_BY_FLUID)
    public ResponseEntity<Iterable<LayerDTO>> getLayersByFluidType(@RequestParam("fluid") String fluid) {
        FluidType fluidType = FluidType.getFluidTypeFromDescriptor(fluid);
        return ResponseEntity.of(layerService.getLayersByFluidType(fluidType));
    }

    @GetMapping(Endpoints.GET_BY_ROCKTYPE)
    public ResponseEntity<Iterable<LayerDTO>> getLayersByRockType(@RequestParam("rock") String rock) {
        RockType rockType = RockType.getRockTypeFromDescriptor(rock);
        return ResponseEntity.of(layerService.getLayersByRockType(rockType));
    }

    @GetMapping(Endpoints.GET_BY_NAME)
    public ResponseEntity<Iterable<LayerDTO>> getLayersByName(@RequestParam("name") String name) {
        return ResponseEntity.of(layerService.getLayersByName(name));
    }

    @GetMapping(Endpoints.GET_BY_PROJECT_ID)
    public ResponseEntity<Iterable<LayerDTO>> getLayersByProjectId(@RequestParam("projectid") Long projectId) {
        return ResponseEntity.of(layerService.getLayersByProjectId(projectId));
    }

    @PostMapping(Endpoints.DELETE)
    public ResponseEntity deleteLayer(@RequestParam("id") Long id) {

        if (!layerService.deleteLayer(id).get())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
    @PostMapping(Endpoints.UPDATE)
    public ResponseEntity<LayerDTO> updateLayer(@RequestBody LayerDTO layerDTO) {
       return ResponseEntity.of(layerService.updateLayer(layerDTO));
    }

}
