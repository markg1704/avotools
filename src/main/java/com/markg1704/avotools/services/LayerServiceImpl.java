package com.markg1704.avotools.services;

import com.markg1704.avotools.datamodel.FluidType;
import com.markg1704.avotools.datamodel.Layer;
import com.markg1704.avotools.datamodel.Project;
import com.markg1704.avotools.datamodel.RockType;
import com.markg1704.avotools.datamodel.dto.LayerDTO;
import com.markg1704.avotools.repositories.LayerRepository;
import com.markg1704.avotools.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LayerServiceImpl implements LayerService {

    private final LayerRepository layerRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Optional<Iterable<LayerDTO>> getLayers() {
        Iterable<LayerDTO> iterable = getLayerDTOList(layerRepository.findAll());
        return Optional.of(iterable);
    }

    @Override
    public Optional<LayerDTO> getLayerById(Long id) {
        Optional<Layer> layer = layerRepository.findById(id);

        if (!layer.isPresent())
            return Optional.empty();

        return Optional.of(transformLayerToLayerDTO(layer.get()));
    }

    @Override
    public Optional<Iterable<LayerDTO>> getLayersByName(String name) {
        Iterable iterable = getLayerDTOList(layerRepository.findByName(name));
        return Optional.of(iterable);
    }

    @Override
    public Optional<Iterable<LayerDTO>> getLayersByWell(String wellName) {
        Iterable<LayerDTO> iterable = getLayerDTOList(layerRepository.findByWell(wellName));
        return Optional.of(iterable);
    }

    @Override
    public Optional<Iterable<LayerDTO>> getLayersByFluidType(FluidType fluidType) {
        Iterable<LayerDTO> iterable = getLayerDTOList(layerRepository.findByFluidType(fluidType));
        return Optional.of(iterable);
    }

    @Override
    public Optional<Iterable<LayerDTO>> getLayersByRockType(RockType rockType) {
        Iterable<LayerDTO> iterable = getLayerDTOList(layerRepository.findByRockType(rockType));
        return Optional.of(iterable);
    }

    @Override
    public Optional<Iterable<LayerDTO>> getLayersByProjectId(Long projectId) {
        Iterable<LayerDTO> iterable = getLayerDTOList(layerRepository.findByProjectId(projectId));
        return Optional.of(iterable);
    }

    @Override
    public Optional<LayerDTO> createLayer(LayerDTO dto) {
        Layer newLayer = layerRepository.save(transformDTOToLayer(dto));
        return Optional.of(transformLayerToLayerDTO(newLayer));
    }

    @Override
    public Optional<Boolean> deleteLayer(Long id) {
        Optional<Layer> layer = layerRepository.findById(id);

        if (!layer.isPresent())
            return Optional.of(Boolean.FALSE);

        layerRepository.deleteById(id);
        Optional<Layer> hasDeleted = layerRepository.findById(id);

        return Optional.of(!hasDeleted.isPresent());
    }

    @Override
    public Optional<LayerDTO> updateLayer(LayerDTO layer) {
        Layer updatedLayer = layerRepository.save(transformDTOToLayer(layer));
        return Optional.of(transformLayerToLayerDTO(updatedLayer));
    }

    private Layer transformDTOToLayer(LayerDTO dto) {

        Layer newLayer = new Layer();

        newLayer.setId(dto.getId());
        newLayer.setName(dto.getName());
        newLayer.setWell(dto.getWell());

        Optional<Project> project = projectRepository.findById(dto.getProjectId());
        newLayer.setProject(project.isPresent() ? project.get() : null);
        newLayer.setFluidType(dto.getFluidType());
        newLayer.setRockType(dto.getRockType());
        newLayer.setPVelocity(dto.getPVelocity());
        newLayer.setSVelocity(dto.getSVelocity());
        newLayer.setDensity(dto.getDensity());

        return newLayer;

    }

    private LayerDTO transformLayerToLayerDTO(Layer layer) {

        Long id = layer.getId();
        String well = layer.getWell();
        String name = layer.getName();
        Long projectId = layer.getProject().getId();
        String fluid = layer.getFluidType().getDescriptor();
        String rock = layer.getRockType().getDescriptor();
        double pVelocity = layer.getPVelocity();
        double sVelocity = layer.getSVelocity();
        double density = layer.getDensity();

        return new LayerDTO(id, well, name, projectId, fluid, rock, pVelocity, sVelocity, density);
    }

    private Iterable<LayerDTO> getLayerDTOList(Iterable<Layer> layers) {

        List<LayerDTO> dtoList = new ArrayList<>();

        for (Layer layer : layers) {
            dtoList.add(transformLayerToLayerDTO(layer));
        }

        return dtoList;
    }

}
