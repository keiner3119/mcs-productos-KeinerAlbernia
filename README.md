Pasos para clonar y correr el API:

· Instalar IDE de preferencia (VS Code, Intellij IDEA, Apache NetBeans u otro. 
  Importante instalar todas las dependencias necesarias para que dicho IDE se adecùe a un proyecto Spring Boot)
  
· Instalar Git: https://github.com/git-for-windows/git/releases/download/v2.47.0.windows.2/Git-2.47.0.2-64-bit.exe

· Instalar Postgres (Permitir instalarle el Pgadmin4): https://sbp.enterprisedb.com/getfile.jsp?fileid=1259174

· Instalar JDK(Versión 17): https://download.oracle.com/java/17/archive/jdk-17.0.12_windows-x64_bin.exe

· Crear base de datos con nombre mcs_products

· Crear un directorio vacío (Carpeta)

· Abrir una terminal de (Preferiblemente de Git) en la ruta del directorio creado o abrir GitBash de manera convencional y ubicarse en la ruta del directorio.

· Clonar el repositorio: git clone https://github.com/keiner3119/mcs-productos-KeinerAlbernia.git

· Obtener última versión: git pull origin master

· Configurar la contraseña de la base de datos en el archivo application.properties (spring.datasource.password=******)
