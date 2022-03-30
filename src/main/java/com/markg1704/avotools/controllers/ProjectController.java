package com.markg1704.avotools.controllers;

import com.markg1704.avotools.datamodel.Project;
import com.markg1704.avotools.datamodel.dto.ProjectDTO;
import com.markg1704.avotools.services.ProjectService;
import com.markg1704.avotools.web.Endpoints;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.PROJECT)
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(Endpoints.GET)
    public ResponseEntity<Iterable<Project>> getAllProjects() {
        return ResponseEntity.of(projectService.getAllProjects());
    }

    @GetMapping(Endpoints.GET_BY_ID)
    public ResponseEntity<Project> getProjectById(@RequestParam("id") Long id) {
        return ResponseEntity.of(projectService.getProjectById(id));
    }

    @PostMapping(Endpoints.CREATE)
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.of(projectService.createProject(projectDTO));
    }
}
