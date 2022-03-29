package com.markg1704.avotools.repositories;

import com.markg1704.avotools.datamodel.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);

}
