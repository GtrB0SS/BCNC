# BCNC

Spring Boot Microservice Example
    Este proyecto es un ejemplo de un microservicio desarrollado en Spring Boot que cumple con los requisitos especificados en el ejercicio. El microservicio tiene tres endpoints que interactúan con las entidades Album y Photo. Además, se incluyen pruebas unitarias y de integración para garantizar la calidad del código.

Tecnologías Utilizadas
    Spring Boot: Framework para el desarrollo de aplicaciones basadas en Java.
    Spring Data JPA: Facilita el acceso a datos utilizando la tecnología JPA.
    H2 Database: Base de datos en memoria para pruebas y desarrollo.
    RestTemplate: Cliente HTTP de Spring para realizar solicitudes a APIs externas.
    JUnit y Mockito: Utilizados para escribir pruebas unitarias.
    Jacoco: Herramienta para medir la cobertura del código de las pruebas.
    GitHub Actions: Se utiliza para CI/CD, ejecuta automáticamente las pruebas y verifica la calidad del código.

Arquitectura y Patrones
La arquitectura del microservicio sigue una estructura de capas:
    Controller: Maneja las solicitudes HTTP y llama a los servicios.
    Service: Contiene la lógica de negocio y coordina la interacción entre repositorios y entidades.
    Repository: Se encarga de la interacción con la base de datos.
    Entity: Representa las entidades del dominio de la aplicación.
    Se utiliza el patrón de diseño DAO (Data Access Object) para separar la lógica de acceso a datos de la lógica de negocio.

Decisiones de Diseño
    Constructor Predeterminado: Se agrega un constructor sin argumentos en las entidades para evitar el error de Hibernate relacionado con la falta de un constructor predeterminado.
    Uso de RestTemplate: Se utiliza RestTemplate para interactuar con servicios web externos y obtener datos.
    Pruebas Unitarias e Integración: Se han implementado pruebas unitarias utilizando JUnit y Mockito. Además, se incluye al menos una prueba de integración que cubre la funcionalidad principal.
    Cobertura de Código: Se utiliza Jacoco para medir la cobertura del código de las pruebas y asegurarse de que la mayoría del código esté cubierto por pruebas.

Eficiencia
    Uso Eficiente de Estructuras de Datos: Se ha prestado especial atención a la elección de estructuras de datos eficientes para optimizar operaciones como lectura, inserción y borrado de datos.

Gestión de Código
    Gestión de Ramas y Commits: Se sigue una metodología de ramas y commits semánticos para organizar y documentar el desarrollo.
    CI/CD con GitHub Actions: Se utiliza GitHub Actions para la integración continua y la implementación continua.

Ejecución del Microservicio
    Para ejecutar el microservicio localmente:
    Clona el repositorio: git clone https://github.com/tuusuario/turepositorio.git
    Ingresa al directorio del proyecto: cd turepositorio
    Ejecuta la aplicación: ./mvnw spring-boot:run
    Ejecución de Pruebas

Para ejecutar las pruebas:
    ./mvnw test

Informe de Cobertura de Código
    Para generar un informe de cobertura de código:

    ./mvnw jacoco:report

    El informe estará disponible en el directorio target/site/jacoco/index.html.

