# text_zenware

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/text_zenware-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

## 5.3 Diagnóstico de logs

## 5.3 Diagnóstico de logs
Analiza el archivo **logs/diagnostico.log** e incluye en el README:
1. Causa raíz de la excepción.
   - `Asignar un valor alfanumérico (String) cuando se espera un valor numérico (Integer)`

2. Estrategia para prevenirla con validaciones.
   - `Agregue una verificación de tipo antes de intentar analizar el valor, use la validación de bean si está en REST`    

3. Nivel de log adecuado para registrar el error y por qué.
   - `Se debe utilizar una advertencia para informar potencialmente al usuario que necesita ingresar otro valor.`

## 5.4 Preguntas AWS
- Explica en qué escenarios preferirías **EC2** frente a **Lambda** (máx. 3 líneas).
  - `Lambda requiere menos control porque está administrado por AWS y no tiene servidores, por lo que hay menos posibilidades.`

- Enumera **tres servicios de observabilidad** (CloudWatch, X‑Ray, CloudTrail, etc.) y su propósito
  en una línea cada uno.
  1. `ServiceNow, más para la gestión de incidentes`
  2. `CloudWatch, plus para monitorear alertas`
  3. `GoogleCloud, más para la centralización y análisis de registros de diferentes aplicaciones`

## 5.5 Ejercicio SQL
1. Consulta: 5 productos con `precio` > 100 000 ordenados desc.
    - `SELECT * FROM productos WHERE precio > 100000 ORDER BY precio DESC LIMIT 5`
2. Explica cuándo un `INDEX(nombre)` mejora la búsqueda por nombre (1 línea).
   -  `Rendimiento mejorado para filtros y ordenamiento de bases de datos en lugar de filtrar y ordenar en una cadena`

