package com.intern.project_sys.service;

import com.intern.project_sys.model.Project;
import com.intern.project_sys.repository.ProjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;
    AutoCloseable autoCloseable;
    Project project;

    @BeforeEach
    void setUp() {
        autoCloseable = org.mockito.MockitoAnnotations.openMocks(this);
        projectService = new ProjectServiceImpl(projectRepository);
        project = new Project(1L, "Project", "Project System", new Date(), new Date());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateNewProject() {
        mock(Project.class);
        mock(ProjectRepository.class);

        when(projectRepository.save(project)).thenReturn(project);
        assert (projectService.createNewProject(project) == project);
    }

    @Test
    void testGetAllProjects() {
        mock(Project.class);
        mock(ProjectRepository.class);

        when(projectRepository.findAll()).thenReturn(java.util.List.of(project));
    }

    @Test
    void testGetProjectById() {
        mock(Project.class);
        mock(ProjectRepository.class);

        when(projectRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(project));
    }

    @Test
    void testUpdateProject() {
        mock(Project.class);
        mock(ProjectRepository.class);

        when(projectRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(project));
        when(projectRepository.save(project)).thenReturn(project);
    }

    @Test
    void testDeleteProject() {
        mock(Project.class);
        mock(ProjectRepository.class);

        projectRepository.deleteById(1L);
    }
}