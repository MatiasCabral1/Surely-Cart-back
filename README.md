# SurelyCart - Backend

## Tecnologías Utilizadas
- Spring Boot v3.2.2: Framework de desarrollo de aplicaciones Java.
- PostgreSQL: Sistema de gestión de bases de datos relacional.

## Instalación

### 1. Configuración de PostgreSQL
   - Asegúrate de tener PostgreSQL instalado y configurado en tu máquina local. Puedes descargarlo desde [aquí](https://www.postgresql.org/download/).
   - Crea una base de datos llamada `cart` en PostgreSQL.

### 2. Clonar el Repositorio
   Clona el repositorio del backend en tu máquina local.
   ```bash
   git clone [https://github.com/tu-usuario/Surely-Cart-backend.git](https://github.com/MatiasCabral1/Surely-Cart-back)
   ```
### 3. Configuración del proyecto
1. Navega al directorio del proyecto clonado.
   ```bash
   cd Surely-Cart-backend
2. Abre el archivo src/main/resources/application.properties y configura la conexión a la base de datos PostgreSQL. Por ejemplo:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/cart
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
3. Recuerda que debemos crear la base de datos cart antes de la ejecucion.
### 4. Ejecucion
En mi caso utilizando eclipse:
1. Click derecho sobre "DemoApplication"  y ejecutar:
   ```bash
   Run as Java aplication
2. La aplicacion corre en http://localhost:8081/  

## Autor
- [Matias Cabral](https://github.com/MatiasCabral1)
