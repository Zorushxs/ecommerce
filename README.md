E-commerce Application
Este proyecto es una aplicación de comercio electrónico que gestiona carritos de compras y productos.

Funcionalidades
Crear un carrito de compras
Obtener un carrito de compras por ID
Agregar un producto a un carrito de compras
Eliminar un carrito de compras
Tecnologías Utilizadas
Java 17
Spring Boot 3.3.1
Maven
Lombok
SLF4J para logging
Instalación y Ejecución
Clonar el Repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/ecommerce.git
cd ecommerce
Compilar y Empaquetar con Maven:

go
Copiar código
mvn clean package
Ejecutar la Aplicación:

bash
Copiar código
java -jar target/ecommerce-0.0.1-SNAPSHOT.jar
La aplicación se ejecutará en http://localhost:8080.

Uso de la API
Crear un Carrito de Compras
Endpoint:

bash
Copiar código
POST /carts
Ejemplo de Solicitud:

json
Copiar código
curl -X POST http://localhost:8080/carts
Respuesta Exitosa:

json
Copiar código
{
  "id": "d2b3b4de-9786-4c45-a3b5-907e357c6c1e",
  "products": [],
  "lastActivityTime": 1642751241737
}
Obtener un Carrito de Compras
Endpoint:

bash
Copiar código
GET /carts/{cartId}
Ejemplo de Solicitud:

json
Copiar código
curl -X GET http://localhost:8080/carts/d2b3b4de-9786-4c45-a3b5-907e357c6c1e
Respuesta Exitosa:

json
Copiar código
{
  "id": "d2b3b4de-9786-4c45-a3b5-907e357c6c1e",
  "products": [],
  "lastActivityTime": 1642751241737
}
Agregar un Producto a un Carrito de Compras
Endpoint:

bash
Copiar código
POST /carts/{cartId}/products
Ejemplo de Solicitud:

json
Copiar código
curl -X POST -H "Content-Type: application/json" -d '{"id": 1, "description": "Product A", "amount": 10}' http://localhost:8080/carts/d2b3b4de-9786-4c45-a3b5-907e357c6c1e/products
Respuesta Exitosa:

Copiar código
HTTP/1.1 200 OK
Eliminar un Carrito de Compras
Endpoint:

bash
Copiar código
DELETE /carts/{cartId}
Ejemplo de Solicitud:

json
Copiar código
curl -X DELETE http://localhost:8080/carts/d2b3b4de-9786-4c45-a3b5-907e357c6c1e
Respuesta Exitosa:

Copiar código
HTTP/1.1 200 OK
Contribución
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

Haz un fork del proyecto
Crea una rama para tu feature (git checkout -b feature/NuevaCaracteristica)
Commit de tus cambios (git commit -am 'Añadida NuevaCaracteristica')
Push a la rama (git push origin feature/NuevaCaracteristica)
Crea un nuevo Pull Request
Licencia
Este proyecto está bajo la licencia MIT - ver el archivo LICENSE.md para más detalles.
