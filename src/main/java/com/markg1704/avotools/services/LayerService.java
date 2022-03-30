package com.markg1704.avotools.services;

import com.markg1704.avotools.datamodel.FluidType;
import com.markg1704.avotools.datamodel.Layer;
import com.markg1704.avotools.datamodel.RockType;
import com.markg1704.avotools.datamodel.dto.LayerDTO;

import java.util.Optional;

public interface LayerService {

    Optional<Iterable<LayerDTO>> getLayers();

    Optional<LayerDTO> getLayerById(Long id);

    Optional<Iterable<LayerDTO>> getLayersByName(String name);

    Optional<Iterable<LayerDTO>> getLayersByWell(String wellName);

    Optional<Iterable<LayerDTO>> getLayersByFluidType(FluidType fluidType);

    Optional<Iterable<LayerDTO>> getLayersByRockType(RockType rockType);

    Optional<Iterable<LayerDTO>> getLayersByProjectId(Long projectId);

    Optional<LayerDTO> createLayer(LayerDTO layer);

    Optional<Boolean> deleteLayer(Long id);

    Optional<LayerDTO> updateLayer(LayerDTO layer);

}
