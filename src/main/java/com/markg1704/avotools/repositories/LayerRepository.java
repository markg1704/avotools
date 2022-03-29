package com.markg1704.avotools.repositories;

import com.markg1704.avotools.datamodel.FluidType;
import com.markg1704.avotools.datamodel.Layer;
import com.markg1704.avotools.datamodel.RockType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LayerRepository extends CrudRepository<Layer, Long> {

    List<Layer> findByName(String name);

    List<Layer> findByWell(String wellName);

    List<Layer> findByFluidType(FluidType fluidType);

    List<Layer> findByRockType(RockType rockType);

}
