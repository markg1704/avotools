package com.markg1704.avotools.services;

import com.markg1704.avotools.datamodel.Project;
import com.markg1704.avotools.datamodel.dto.ProjectDTO;
import com.markg1704.avotools.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Iterable<Project>> getProjectByName(String name) {
        return Optional.of(projectRepository.findByName(name));
    }

    @Override
    public Optional<Iterable<Project>> getAllProjects() {
        return Optional.of(projectRepository.findAll());
    }

    @Override
    public Optional<Project> createProject(ProjectDTO projectDTO) {
        Project newProject = transformProjectDTO(projectDTO);
        return Optional.of(projectRepository.save(newProject));
    }

    @Override
    public Optional<Boolean> deleteProject(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> updateProject(ProjectDTO projectDTO) {
        return Optional.empty();
    }

    private Project transformProjectDTO(ProjectDTO projectDTO) {

        Project project = new Project();

        project.setName(projectDTO.getName());

        return project;
    }
}
