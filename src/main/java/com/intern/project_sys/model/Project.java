package com.intern.project_sys.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "PROJECT_TABLE")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @Column(name = "PROJECT_NAME")
    @NotBlank(message = "Project name is required")
    @Size(max = 50, message = "Project name must be less than or equal to 50 characters")
    private String projectName;

    @Column(name = "PROJECT_DESCRIPTION")
    @NotBlank(message = "Project description is required")
    private String projectDescription;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "PROJECT_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date projectStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "PROJECT_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;
}
