# Sistema de Gestión de Pedidos (Spring Boot + PostgreSQL)

Este es un sistema de gestión de pedidos que utiliza **Spring Boot**, **PostgreSQL** y expone una API REST para crear, listar y filtrar pedidos. Además, implementa manejo de errores transaccionales y registro en una tabla `log_error`.

---

## Tecnologías utilizadas

- Java 17 (JDK de Eclipse Temurin)
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- PostgreSQL 16.3
- HikariCP
- Maven
- Postman (para pruebas)
- (Frontend opcional con HTML/CSS o Vue)

---

## Estructura del proyecto

* `controller/`: Contiene las clases que exponen los endpoints REST. Se encarga de recibir y procesar las solicitudes HTTP.

  * `PedidoController.java`: Define los endpoints para operaciones CRUD y búsqueda por estado.
  * `LogErrorController.java`: Permite consultar los errores registrados.

* `entity/`: Contiene las clases que representan las entidades del modelo de datos (tablas en la base de datos).

  * `Pedido.java`: Entidad principal que representa un pedido.
  * `LogError.java`: Entidad que guarda los errores ocurridos durante operaciones.

* `repository/`: Contiene las interfaces que extienden `JpaRepository` para acceder a la base de datos.

  * `PedidoRepository.java`: Repositorio para la entidad `Pedido`.
  * `LogErrorRepository.java`: Repositorio para la entidad `LogError`.

* `service/`: Contiene la lógica de negocio.

  * `PedidoService.java`: Gestiona la creación de pedidos, búsquedas y manejo de errores con rollback.

* `resources/`: Contiene los recursos como configuraciones y archivos estáticos.

  * `application.properties`: Archivo de configuración para la base de datos y puerto.
  * `static/index.html`: Página web opcional para visualizar o probar el sistema.

* `PedidosApplication.java`: Clase principal que lanza la aplicación Spring Boot.

* `ConcurrentTest.java`: Clase de prueba que permite simular múltiples peticiones concurrentes para validar la robustez de las transacciones.


## Configuración de base de datos

`src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
```
## Cómo ejecutar el proyecto

cd pedidos
./mvnw spring-boot:run



