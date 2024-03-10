package com.intern.project_sys.service;

import com.intern.project_sys.error.ProjectNotFoundException;
import com.intern.project_sys.model.Project;
import com.intern.project_sys.repository.ProjectRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() throws ProjectNotFoundException {
        List<Project> projectList = projectRepository.findAll();
        if (projectList.isEmpty()) {
            throw new ProjectNotFoundException("No Projects Found");
        }
        return projectList;
    }


    @Override
    public Project getProjectById(Long id) throws ProjectNotFoundException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("No Project Found for the given id " + id));
        return project;
    }

    @Override
    public Project updateProject(Long id, Project project) throws ProjectNotFoundException {
        Project projectToUpdate =  projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("No Project Found for the given id " + id));

        if (StringUtils.isNotBlank(project.getProjectName()) && !project.getProjectName().equals(projectToUpdate.getProjectName())) {
            projectToUpdate.setProjectName(project.getProjectName());
        }
        if (StringUtils.isNotBlank(project.getProjectDescription()) && !project.getProjectDescription().equals(projectToUpdate.getProjectDescription())) {
            projectToUpdate.setProjectDescription(project.getProjectDescription());
        }
        if (project.getProjectStartDate() != null && !project.getProjectStartDate().equals(projectToUpdate.getProjectStartDate())) {
            projectToUpdate.setProjectStartDate(project.getProjectStartDate());
        }
        if (project.getProjectEndDate() != null && !project.getProjectEndDate().equals(projectToUpdate.getProjectEndDate())) {
            projectToUpdate.setProjectEndDate(project.getProjectEndDate());
        }

        return projectRepository.save(projectToUpdate);
    }

    @Override
    public void deleteProject(Long id) throws ProjectNotFoundException {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("No Project Found for the given id " + id));
        projectRepository.delete(project);
    }


}
