# 🎬 API de Gestión de Películas

Proyecto backend desarrollado con **Spring Boot** que permite gestionar un catálogo de películas y sus directores.

## 📌 Funcionalidades

- Listar todas las películas
- Buscar una película por su ID
- Buscar películas por ID de director
- Añadir una nueva película con validaciones
- Añadir un nuevo director
- Listar todos los directores

## 🔗 Relaciones

- Cada **película** está asociada a un único **director** (`@ManyToOne`)
- Cada **director** puede tener varias **películas** (`@OneToMany`)

## ✅ Validaciones

Las entidades cuentan con validaciones como:

- El título no puede estar en blanco
- El año debe estar entre 1900 y 2025
- La duración debe ser entre 15 y 180 minutos
- El director no puede ser nulo

## 🧪 Tests

Se han implementado pruebas con `MockMvc` para verificar:

- ✔️ Respuesta 200 al listar películas
- ✔️ Código 201 al añadir película válida
- ✔️ Código 400 al añadir película inválida
- ✔️ Buscar una película por ID existente
- ✔️ Buscar películas por ID de director

Incluye un `@TestConfiguration` que inserta un director por defecto para facilitar los tests.

## 🛠️ Tecnologías usadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 (base de datos en memoria)
- Bean Validation
- JUnit 5 + MockMvc
- Maven

## 🗃️ Estructura

```
├── model
│   ├── Pelicula.java
│   └── Director.java
├── controller
│   ├── PeliculaController.java
│   └── DirectorController.java
├── repository
│   ├── PeliculaRepository.java
│   └── DirectorRepository.java
├── service
│   ├── PeliculaService.java
│   └── DirectorService.java
├── config
│   └── TestDataConfig.java
└── PeliculaControllerTests.java
```

---

## ▶️ Cómo ejecutar el proyecto
```bash
mvn spring-boot:run
```

## 🧪 Cómo ejecutar los tests
```bash
mvn test
```

---

**Autor**: Proyecto de aprendizaje desarrollado por Sergio Marín como parte de su camino para convertirse en desarrollador backend en Java 🚀
