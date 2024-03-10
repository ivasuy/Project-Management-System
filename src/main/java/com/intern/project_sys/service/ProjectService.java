package com.intern.project_sys.service;

import com.intern.project_sys.error.ProjectNotFoundException;
import com.intern.project_sys.model.Project;

import java.util.List;

public interface ProjectService {
    Project createNewProject(Project project);

    List<Project> getAllProjects() throws ProjectNotFoundException;

    Project getProjectById(Long id) throws ProjectNotFoundException;

    Project updateProject(Long id, Project employee) throws ProjectNotFoundException;

    void deleteProject(Long id) throws ProjectNotFoundException;
}
