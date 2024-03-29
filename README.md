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
   git clone https://github.com/MatiasCabral1/Surely-Cart-back.git
   ```
### 3. Configuración del proyecto
1. Navega al directorio del proyecto clonado.
   ```bash
   cd Surely-Cart-back
2. Abre el archivo src/main/resources/application.properties y configura la conexión a la base de datos PostgreSQL. Por ejemplo:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/cart
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
### Antes de iniciar la app:
   1. Recuerda que debemos crear la base de datos cart.
   2. Ejecutar el script ddbbInit en la BBDD que se encuentra en la carpeta raiz del repositorio.
### 4. Ejecucion
En mi caso utilizando eclipse:
1. Click derecho sobre "DemoApplication"  y ejecutar:
   ```bash
   Run as Java aplication
2. La aplicacion corre en http://localhost:8081/

## Autor
- [Matias Cabral](https://github.com/MatiasCabral1)
