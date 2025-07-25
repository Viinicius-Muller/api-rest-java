# Java REST API

A generic RESTful API for a doctor CRUD system using Spring, Flyway DB, Lombok, and MySQL.

## Features

- Create doctors with personal information
- Update previously registered information
- Deactivate doctors who are no longer active
- List all active doctors
- List a specific doctor by their ID

### Built With

- **Backend**
  - [Java](https://www.java.com/en/)
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Bean Validation](https://beanvalidation.org/)
  - [Lombok](https://projectlombok.org/)
- **Database**
  - [MySQL](https://www.mysql.com/)
  - [Flyway](https://www.red-gate.com/products/flyway/community/)
- **Tools**
  - [Maven](https://maven.apache.org/)
  - [Postman](https://www.postman.com/)

## Getting Started

### Prerequisites

- **[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java21) - Version 21 or higher**
    ```bash
    # Ubuntu
    sudo apt-get install openjdk-21-jdk
    ```
- **[Maven](https://maven.apache.org/download.cgi)**
    ```bash
    # Ubuntu
    sudo apt-get install maven
    ```
- **[MySQL Server](https://dev.mysql.com/downloads/installer/) - Database Server**
    ```bash
    # Ubuntu
    sudo apt install mysql-server
    ```

### Installation

1. **Clone the repository**
    ```bash
    git clone [https://github.com/Viinicius-Muller/api-rest-java.git](https://github.com/Viinicius-Muller/api-rest-java.git)
    ```
2. **Open the project in your preferred Java IDE**
3. **Install Maven dependencies**
    ```bash
    mvn install
    ```

### Database Setup

1. **Create a new database in MySQL**
  - Use the command `CREATE DATABASE your_database_name;`
2. **Configure the database connection**
  - Open the file `src/main/resources/application.properties`
  - Update the following settings with your MySQL server credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://127.0.0.1:3306/your_database_name
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      ```
3. **Run the application**
  - The database tables will be automatically created by the Flyway migrations.

## Usage

To run the application, connect to your database server and run the Spring application from your IDE, or use the Maven command in the root directory:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## API Endpoints

API endpoints for use. It is recommended to use [Postman](https://www.postman.com/) for API consumption.

- **GET `/medicos`**
  - Returns a list of all active doctors.
  - **Query Parameters:**
    - `sort` - Sorts the list based on a database column (e.g., `sort=nome`).
    - `size` - Limits the number of doctors per page.
    - `page` - Switches the page being displayed.
  - Example: `http://localhost:8080/medicos?sort=nome&size=2`

- **GET `/medicos/{id}`**
  - Returns the information for a single doctor by their ID.

- **POST `/medicos`**
  - Creates a new doctor in the database.
  - **Request Body:** Requires a JSON object with the doctor's personal information.
  - Example:
    ```json
    {
      "nome": "Alexandre Alves",
      "email": "alexandre.alves@voll.med",
      "crm": "123456",
      "telefone": "21999999",
      "especialidade": "DERMATOLOGIA",
      "endereco": {
        "cidade": "São Paulo",
        "uf": "SP",
        "cep": "892929200",
        "bairro": "Bairro Paulista",
        "logradouro": "Rua Paulista",
        "numero": "007",
        "complemento": "Apartment"
      }
    }
    ```
  - **Optional Fields:** `numero` and `complemento`.
  - **CRM:** Must contain 4 to 6 digits.
  - **Especialidade (Specialty):** Can be `GINECOLOGIA`, `ORTOPEDIA`, `CARDIOLOGIA`, or `DERMATOLOGIA`.

- **PUT `/medicos/{id}`**
  - Updates a doctor's registration information by their ID.
  - **Request Body:** Requires a JSON object with the information to be updated.
  - Example:
    ```json
    {
      "id": 1,
      "telefone": "369988222",
      "nome": "Alexandre Vieira Alves",
      "endereco": {
        "cidade": "São Paulo",
        "uf": "SP",
        "cep": "29298181",
        "bairro": "Bairro Corujinha",
        "logradouro": "Rua Paulista",
        "numero": "007",
        "complemento": "House"
      }
    }
    ```
  - **Updatable Fields:** `nome`, `telefone`, and `endereco`.

- **DELETE `/medicos/{id}`**
  - Marks a doctor as inactive in the database (logical deletion).

## Contributing

#### Bug Reports and Contributions
To contribute to this project, please use the dedicated [issues page](https://github.com/Viinicius-Muller/api-rest-java/issues).

### Contact

André Vinicius Müller | [LinkedIn](https://www.linkedin.com/in/andr%C3%A9-vinicius-muller-432b17327) | zandreviniciusmuller@gmail.com
