# CRUD Operations for Project Management System

**1. Prerequisites:**

- JDK (Java Development Kit) installed on your system
- Maven (Dependency Management Tool) installed
- Any IDE (Integrated Development Environment) such as IntelliJ IDEA, Eclipse, or Spring Tool Suite

**2. Setup Instructions:**

- Clone the project repository from GitHub Repository URL or download the source code as a ZIP file.
- Open the project in your preferred IDE.
- Ensure that JDK and Maven are properly configured in your IDE.

**3. Database Setup:**

- The project uses an in-memory H2 database. No additional setup is required.

**4. Running the Application:**

- Run the **`ProjectApplication.java`** class to start the Spring Boot application.
- The application will be accessible at **`http://localhost:8080`**.

**5. API Usage:**

- **Create a New Project:**
    - **Endpoint:** **`POST /api/projects/createNewProject`**
    - **Request Body:** JSON object representing the new project
    - **Example Request:**
        
        ```
        POST /api/projects/createNewProject
        Content-Type: application/json
        
        {
            "projectName": "New Project",
            "projectDescription": "Description of the new project",
            "projectStartDate": "2024-03-10",
            "projectEndDate": "2024-06-10"
        }
        ```
        
    - **Response:** Returns the newly created project object.
- **Get All Projects:**
    - **Endpoint:** **`GET /api/projects/getAllProjects`**
    - **Response:** Returns a list of all projects.
- **Get Project by ID:**
    - **Endpoint:** **`GET /api/projects/getProject/{id}`**
    - **Path Parameter:** **`id`** - ID of the project to retrieve
    - **Response:** Returns the project object with the specified ID.
- **Update Project:**
    - **Endpoint:** **`PUT /api/projects/updateProject`**
    - **Request Parameters:** **`id`** - ID of the project to update
    - **Request Body:** JSON object representing the updated project
    - **Example Request:**
        
        ```
        PUT /api/projects/updateProject?id=1
        Content-Type: application/json
        
        {
            "projectName": "Updated Project Name",
            "projectDescription": "Updated project description"
        }
        ```
        
    - **Response:** Returns the updated project object.
- **Delete Project:**
    - **Endpoint:** **`DELETE /api/projects/deleteProject`**
    - **Request Parameter:** **`id`** - ID of the project to delete
    - **Example Request:**
        
        ```
        DELETE /api/projects/deleteProject?id=1
        ```
        
    - **Response:** Returns a success message confirming the deletion of the project.

**6. Accessing H2 Console:**

- H2 Console is enabled in the application properties.
- Access the H2 Console at **`http://localhost:8080/h2-console`**.
- Use the JDBC URL **`jdbc:h2:mem:mydb`** and other default credentials to login.

**7. Additional Notes:**

- Swagger Link For Testing API : [http://localhost:8080/swagger-ui/#/](http://localhost:8080/swagger-ui/index.html)