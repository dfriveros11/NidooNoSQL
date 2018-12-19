# NidooNoSQL
Proyecto para Nidoo utilizando mongo como base de datos

## Instrucciones para inicializar mongo
docker run mongo:4.0.4
docker run -d --name some-mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo
