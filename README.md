# 📽️ API REST de Películas

Este proyecto es una API REST básica construida con **Spring Boot**, que permite gestionar un catálogo de películas y directores. Ha sido desarrollado con enfoque en buenas prácticas y tests automatizados, como parte del aprendizaje backend en Java.

## 🚀 Funcionalidades

### Películas 🎬
- Listar todas las películas (`GET /peliculas`)
- Añadir una nueva película (`POST /peliculas`)
- Obtener una película por ID (`GET /peliculas/{id}`)
- Buscar películas por ID de director (`GET /peliculas/director/{id}`)

### Directores 🎥
- Listar todos los directores (`GET /directores`)
- Añadir un nuevo director (`POST /directores`)

## ✅ Validaciones incluidas
- No se puede crear una película sin título, duración, año o director.
- El año debe estar entre 1900 y 2025.
- La duración debe ser entre 15 y 180 minutos.

## 🧪 Tests automatizados
Se incluyen pruebas con **MockMvc** que validan:
- Respuestas correctas (códigos 200, 201 y 400)
- Comportamiento esperado en los endpoints
- Inserción y recuperación de películas

Además, se utiliza una configuración de test con un `@TestConfiguration` que inyecta automáticamente un director para todos los tests.

## 🛠️ Tecnologías usadas
- Java 17
- Spring Boot 3.4
- Maven
- H2 (base de datos en memoria para desarrollo y tests)
- JPA (Hibernate)
- Validación con Jakarta Validation (JSR-380)
- JUnit 5
- MockMvc para tests de integración

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
