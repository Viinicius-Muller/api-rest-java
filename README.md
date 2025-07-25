# API REST Java

Restful API genérica de sistema CRUD de médicos utilizando Spring, Flyway DB, Lombok e MySQL.

## Features

- Criação de médicos com informações pessoais
- Atualização de informações já cadastradas
- Desativação de médicos não mais ativos
- Listagem de médicos ativos
- Listagem de médico por Id

### Tecnologias Utilizadas

- **Backend**
    - [Java](https://www.java.com/en/)
    - [Spring Boot](https://spring.io/projects/spring-boot)
    - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
    - [Bean Validation](https://beanvalidation.org/)
    - [Lombok](https://projectlombok.org/)
- **Banco de Dados**
    - [MySQL](https://www.mysql.com/)
    - [Flyway](https://www.red-gate.com/products/flyway/community/)
- **Ferramentas**
    - [Maven](https://maven.apache.org/)
    - [Postman](https://www.postman.com/)

## Instruções

### Pre requisitos

- **[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java21) - Versão 21 ou superior**

```bash
# Ubuntu
sudo apt-get install openjdk-21-jdk
```

- **[Maven](https://maven.apache.org/download.cgi)**

```bash
# Ubuntu
sudo apt-get install maven
```

- **[MySQL Server](https://dev.mysql.com/downloads/installer/) - Servidor Banco de Dados**

```bash
# Ubuntu
sudo sudo apt install mysql-server
```

### Instalação

1. **Clone o projeto**

```bash
git clone https://github.com/Viinicius-Muller/api-rest-java.git
```

2. **Abra o projeto em alguma IDE Java**
3. **Instale as dependências Maven**

```bash
mvn install
```

### Setup do Banco de Dados

1. **Crie um novo banco de dados no MySQL**

- Utilize o comando `CREATE DATABASE nome_banco_de_dados`

2. **Configure a conexão do banco de dados**

- Abra o arquivo `src/main/resources/application.properties`
- Configure as seguintes configurações com os dados do seu servidor MySQL:

```bash
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/nome_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. **Execute a aplicação**

- As tabelas do banco de dados serão automaticamente criadas pelas migrations do Flyway

## Uso

Para rodar a aplicação, conecte o servidor do Banco de Dados e execute a aplicação Spring via IDE, ou utilize o comando do Maven na pasta raiz:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

Endpoints da API para o uso. Recomendado o [Postman](https://www.postman.com/) para consumo de API.

- **GET `/medicos`**
    - Retorna uma lista de todos os médicos ativos
      **Queries:**
        - Ordem - ordena a lista de acordo a uma coluna do Banco de Dados
    - Tamanho - limita o tamanho de médicos por página da lista
    - Pagina - alterna a pagina que demonstra os médicos
    - Exemplo de GET: `http://localhost:8080/medicos?ordem=nome&tamanho=2`
- **GET `/medicos/{id}`**
    - Retorna a informação de um médico pelo seu Id
- **POST `/medicos`**

    - Cria um novo médico no banco de dados
    - Request Body: Requer um JSON com informações pessoais do médico
    - Exemplo de post:

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
      "complemento": "Apartamento"
    }
  }
  ```

  **Campos Opcionais**: Número e complemento.

    - **CRM:** Valor deve conter 4 a 6 dígitos.
    - **Especialidade:** Pode ser `GINECOLOGIA`, `ORTOPEDIA`, `CARDIOLOGIA` ou `DERMATOLOGIA`.

- **PUT `/medicos/{id}`**
    - Atualiza informações cadastrais de um médico pelo Id
    - Request Body: Requer um JSON com as informações a serem atualizadas do médico
    - Exemplo de PUT:
  ```json
    {
    "id": 1,
    "telefone": "369988222",
    "nome": "Alexandre Vieira Alves"
    "endereco": {
        "cidade": "São Paulo",
        "uf": "SP",
        "cep": "29298181",
        "bairro": "Bairro Corujinha",
        "logradouro": "Rua Paulista",
        "numero": "007",
        "complemento": "Casa"
        }
    }
  ```
  **Campos atualizáveis:** Endereço, nome e telefone.
- **DELETE `/medicos/{id}`**
    - Marca um médico como inativo no Banco de Dados

## Contribuições

#### Reportes de Bug e Contribuições

Para contribuir com esse projeto utilize a [página](https://github.com/Viinicius-Muller/api-rest-java/issues) dedicada.

### Contato

André Vinicius Müller | [Linkedin](www.linkedin.com/in/andré-vinicius-muller-432b17327) | zandreviniciusmuller@gmail.com
