package com.markg1704.avotools.services;

import com.markg1704.avotools.datamodel.Project;
import com.markg1704.avotools.datamodel.dto.ProjectDTO;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> getProjectById(Long Id);
    Optional<Iterable<Project>> getProjectByName(String name);

    Optional<Iterable<Project>> getAllProjects();

    Optional<Project> createProject(ProjectDTO projectDTO);

    Optional<Boolean> deleteProject(Long id);

    Optional<Project> updateProject(ProjectDTO projectDTO);

}
