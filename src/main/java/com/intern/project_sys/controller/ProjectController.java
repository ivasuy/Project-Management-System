package com.intern.project_sys.controller;

import com.intern.project_sys.error.ProjectNotFoundException;
import com.intern.project_sys.model.Project;
import com.intern.project_sys.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    /*POST/createNewProject - Creates a new Project*/
    @PostMapping("/createNewProject")
    public Project createNewProject(@Valid @RequestBody Project project) {
        return projectService.createNewProject(project);
    }

    /*GET /getAllProjects - Returns a list of all Project*/
    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects() throws ProjectNotFoundException {
        return projectService.getAllProjects();
    }

    /*GET /getProject/{id} - Returns a specific Project by id*/
    @GetMapping("/getProject/{id}")
    public Project getProjectById(@PathVariable("id") Long id) throws ProjectNotFoundException {
        return projectService.getProjectById(id);
    }

    /*PUT /updateProject - Updates an existing Project by id*/
    @PutMapping("/updateProject")
    public Project updateProject(@RequestParam Long id, @Valid @RequestBody Project employee) throws ProjectNotFoundException {
        return projectService.updateProject(id, employee);
    }

    /*DELETE /deleteProject - Deletes a Project by id*/
    @DeleteMapping("/deleteProject")
    public String deleteProject(@RequestParam Long id) throws ProjectNotFoundException {
         projectService.deleteProject(id);
         return "Project with id: " + id + " deleted successfully";
    }

}
