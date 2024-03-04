# Code Challenge
## Inclusion Cloud

### Reference Documentation

Puntos del Test de Java:

* Esta prueba técnica consiste en el desarrollo en SpringBoot (Java) de una pequeña funcionalidad definida en el siguiente enlace: https://codeforces.com/problemset/problem/1374/A
* Además de lo indicado en este enlace, se solicita que se implemente un API con un servicio GET, y otro POST, que permita enviar los parámetros de entrada (x, y, n) necesarios para ejecutar la funcionalidad indicada anteriormente, y que devuelva una respuesta con la salida de esa misma funcionalidad.
* El formato del cuerpo de la petición y de la respuesta puede ser XML o JSON. Se deben incluir test unitarios de la funcionalidad desarrollada. La versión de Java a utilizar será Java 11, y la versión de SpringBoot se dejará a la elección del propio usuario.
* Una vez finalizada, la prueba se enviará por correo electrónico indicando todo lo necesario para poder ejecutarla, o se podrá subir a un repositorio de código propio del usuario, informándonos de la finalización y de la subida al repositorio.

### Implementación

Se utiliza el JDK 11 y Spring Boot 2.4.2 el cual es compatible con el JDK 11. 
Se utiliza Gradle para la gestión de dependencias y construcción del proyecto. 
Se utiliza JUnit 5 para la realización de pruebas unitarias.
Se utiliza Lombok para la generación de getters, setters, constructores y otros métodos de utilidad.

La funcionalidad solicitada se encuentra en la clase `RequiredRemainder` 
y se expone a través de un controlador REST en la clase `RequiredReminderController`.
El desarrollo de dicha funcionalidad se encuentra en el método `calculateRequiredRemainder` de la clase `RequiredRemainder`.
Se empieza usando el valor de 'n' y se evalua la busqueda de un valor 'k' que cumpla con la condición 
de que el residuo de la división de 'k' entre 'x' sea igual a 'y'. Se realiza de esta forma porque se evidencia 
que los resultados estan cerca del numero 'n' y se puede realizar una busqueda lineal para encontrar el valor de 'k'.

### Ejecución en un Terminal

* Asegurarse de tener el JDK 11 instalado.
* Asegurarse de tener Gradle instalado.
* Clonar el repositorio.
* Navegar a la carpeta del proyecto.
* Ejecutar el comando `./gradlew bootRun`.
* La aplicación estará disponible en `http://localhost:8080`.

### Ejecución en un contenedor Docker

* Asegurarse de tener Docker instalado.
* Clonar el repositorio.
* Navegar a la carpeta del proyecto.
* Ejecutar el comando `./gradlew build`.
* Ejecutar el comando `docker build -t inclusion-cloud .`.
* Ejecutar el comando `docker run -p 8080:8080 inclusion-cloud`.
* La aplicación estará disponible en `http://localhost:8080`.

### Ejecución de Pruebas Unitarias

* Asegurarse de tener el JDK 11 instalado.
* Asegurarse de tener Gradle instalado.
* Clonar el repositorio.
* Navegar a la carpeta del proyecto.
* Ejecutar el comando `./gradlew test`.
* Se mostrará un reporte de las pruebas realizadas.

### CURL de ejecución de la API

* GET:
  * curl --request GET --url http://localhost:8080/required-remainder/7/5/12345
  * curl --request GET --url 'http://localhost:8080/required-remainder?x=7&y=5&n=12345'
* POST:
  * curl --request POST \
    --url http://localhost:8080/required-remainder \
    --header 'Content-Type: application/json' \
    --header 'User-Agent: insomnia/8.6.1' \
    --data '{
    "x": 7,
    "y": 5,
    "n": 12345
    }'
