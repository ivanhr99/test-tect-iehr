# test-tect-iehr
test-tect de Iván Hernández R.
Prueba TEcnica de Ivan HEnrnadez R.

APi REst de "identityDocuments"
conectando a mongo DB una base nombre : test-tec ; local :  localhost:27017/test-tec
Con funciones de CRUD para la coleccion identityDocument
Se puede realizar las pruebas desde Postman importando el archivo test-tec-iehr.postman_collection.json
Utiliza Cors  permitiendo localhost
y JWT token configurado para que dure 1 hora
el cual en localhost:8080/authenticate se puede generar
con las credenciales "Ivanhr" y  "Pa$$w0rd" el archivo test-tec-iehr.postman_collection.json
lleva la prueba de generar el token.
