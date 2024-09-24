# Extendiendo las capacidades de las plataformas IoT: Una aplicación práctica

## Resumen

La Internet de las Cosas (IoT) está permitiendo construir un mundo en el que lo físico se entremezcla con los procesos digitales, generando beneficios en sectores como la industria, las ciudades inteligentes y la agricultura. Este proyecto se centra en extender una plataforma IoT existente, como ThingsBoard, para ofrecer mecanismos de gestión y mantenimiento avanzados. Se aplicará esta extensión en el SmartCity Lab del grupo TaTami, integrando dispositivos IoT en una solución más amplia.

## Tabla de contenidos

1. Introducción
2. Estado del arte
3. Análisis del problema
4. Diseño de la solución
5. Implementación
6. Implantación
7. Conclusiones
8. Trabajos futuros
9. Referencias
10. Anexos

## Introducción

### Motivación

Las soluciones IoT están revolucionando la forma en que interactuamos con nuestro entorno, optimizando recursos y eficiencia. Sin embargo, la gestión y mantenimiento de infraestructuras complejas sigue siendo un desafío.

### Objetivos

- Crear un sistema para implementar operaciones personalizables en infraestructuras IoT.
- Ofrecer una interfaz integrable y orquestar operaciones de manera automatizada.
- Permitir un alto grado de personalización para diferentes ámbitos de uso.

### Impacto esperado

- Flexibilidad y adaptabilidad en entornos IoT.
- Reducción de costes y tiempos de mantenimiento.
- Mejora en la resiliencia y seguridad del sistema.
- Mayor autonomía operativa de los dispositivos IoT.

### Metodología

Se seguirá una metodología iterativa y centrada en el desarrollo ágil, revisando el estado del arte, diseñando alternativas, implementando la solución y analizando su implantación en un entorno real.

## Estado del arte

### La Internet de las Cosas

La IoT es una red de dispositivos conectados que recopilan y actúan sobre datos del entorno. Ejemplos incluyen electrodomésticos inteligentes, automóviles conectados y sistemas de climatización.

### Las Plataformas IoT

Las plataformas IoT facilitan la gestión, monitorización y análisis de datos de dispositivos IoT. Componentes clave incluyen identificación, sensado, comunicación, computación, servicios y semántica.

### Plataformas IoT actuales

- **AWS IoT**: Amplia gama de servicios de gestión de dispositivos y datos.
- **ThingsBoard**: Plataforma open-source para recolección, procesamiento y visualización de datos.
- **Azure IoT Hub**: Enfoque en la seguridad e integración con otros servicios de Azure.

## Análisis del problema

### Observaciones

Las plataformas IoT actuales carecen de capacidades avanzadas de gestión y personalización, planificación de operaciones y presentan riesgos de seguridad.

### Justificación del proyecto

Desarrollar un sistema que aborde estas limitaciones, ofreciendo una interfaz para lanzar meta-operaciones personalizables y planificadas, y monitorizar sus resultados.

### Riesgos y consideraciones

- Complejidad técnica y de integración.
- Seguridad y escalabilidad.
- Costes de implementación y aceptación por parte de los usuarios.

## Diseño de la solución

### Soluciones planteadas

1. Desarrollo de un módulo personalizado para ThingsBoard.
2. Desarrollo de microservicios para gestión de operaciones.
3. Adaptación de la funcionalidad de comandos RPC de ThingsBoard.

### Solución elegida

Desarrollo de una API REST que publique operaciones en colas de mensajería y reciba los resultados de los dispositivos.

### Arquitectura

- **Base de datos**: MySQL.
- **API REST**: Java 17, Spring Boot.
- **Bróker de mensajería**: MQTT.
- **Plataforma IoT**: ThingsBoard.
- **Dispositivos**: Reciben operaciones y responden con estados.

### Procesos

1. Creación y publicación de operaciones.
2. Recepción y almacenamiento de mensajes de estado.
3. Consulta y modificación de operaciones.

### Modelo de datos

Entidades principales: Operación, Mensaje, Paquete, Planificación.

## Implementación

### Herramientas y entorno de desarrollo

- **Lenguaje de programación**: Java 17.
- **Base de datos**: MySQL.
- **Mensajería**: MQTT.
- **Contenedores**: Docker.
- **Control de versiones**: GIT.
- **Pruebas y validación**: JUnit, Mockito, Swagger-UI.

### Arquitectura de la aplicación

Patrón de arquitectura hexagonal, separando la lógica de negocio de los adaptadores externos.

### Desarrollo de la solución

- **Modelo de datos**: Clases entidad y DTO.
- **Repositorios**: Operaciones CRUD.
- **Mappers**: Transformación entre entidades y DTOs.
- **Servicios**: Gestión de operaciones, mensajes, planificación y envío/recepción de mensajes.
- **Controlador REST**: Endpoints para las operaciones.
- **Aplicación**: Clase principal con configuración de Spring Boot.

### Testing y validación

- **Pruebas unitarias**: JUnit y Mockito.
- **Pruebas de validación**: Swagger-UI y MQTT Explorer.

## Implantación

### Objetivos

- Adaptar la solución al entorno del SmartCity Lab.
- Automatizar la gestión de dispositivos IoT.
- Mejorar la seguridad y simplificar el monitoreo de operaciones.

### Plan de despliegue

1. **Preparación**: Revisión de la infraestructura y configuración del entorno de pruebas.
2. **Configuración inicial**: Despliegue de componentes y configuración de operaciones.
3. **Testing**: Verificación de la solución en el entorno de pruebas.
4. **Despliegue**: Implementación en el entorno real y monitorización.

### Configuración de las operaciones

- **SCRIPT**: Ejecución de scripts, modificación de archivos y actualización de certificados.
- **UPDATE**: Actualización de versiones de software.
- **CUSTOM**: Ejecución de comandos y peticiones REST.

### Plan de pruebas

- **Funcionales**: Verificación de operaciones configuradas.
- **Seguridad**: Asegurar comunicaciones cifradas.
- **Escalabilidad**: Pruebas de carga.
- **Integración**: Revisión de la integración con componentes existentes.

## Conclusiones

El proyecto ha cumplido con los objetivos planteados, proporcionando una solución integrable y personalizable para la gestión de infraestructuras IoT. La aplicación permite orquestar operaciones de manera efectiva, reduciendo la intervención humana y mejorando la seguridad y eficiencia del sistema.

## Trabajos futuros

- Integración con otros protocolos industriales.
- Mejor sincronización entre réplicas del microservicio.
- Mejora de la seguridad con gestores de identidades.
- Desarrollo de integraciones con dispositivos populares.

## Referencias

1. A. A. Laghari, et al., "A review and state of art of Internet of Things (IoT)," Archives of Computational Methods in Engineering, 2021.
2. L. Gomez D'Orazio, et al., "Integración de una red de sensores con una plataforma IoT para control inteligente de aulas," XXVIII Congreso Argentino de Ciencias de la Computación (CACIC), 2022.
3. C. Sobrino, "QUE SON LAS PLATAFORMAS IOT Y SUS APLICACIONES EN LA INDUSTRIA," 2023.
4. alfaiot-webmaster, "¿Qué es una plataforma IOT? Guía completa," 2023.
5. AWS, "IoT- Información general."
6. Thingsboard, "What is ThingsBoard?"
7. Microsoft, "Azure IoT Hub."
8. Red Hat, "¿Qué es una arquitectura de aplicaciones?" 2023.
9. AWS, "¿Qué es una base de datos relacional?"
10. D. Soni y A. Makwana, "A survey on mqtt: a protocol of internet of things (iot)," ICTPACT-2017.
11. AWS, "¿Qué es MQTT?"
12. E. Salguero, "Arquitectura Hexagonal," 2018.
13. Baeldung, "Hibernate Inheritance Mapping," 2024.
14. Baeldung, "Quick Guide to MapStruct," 2024.
15. Baeldung, "A Guide to the Spring Task Scheduler," 2024.
16. T. Bormans, "Medium," 2024.

## Anexos

### Glosario

- **API REST**: Patrón de diseño de servicios web que permite la conexión mediante el protocolo HTTP.
- **Bash**: Shell de comandos para sistemas operativos Linux y macOS.
- **Bróker MQTT**: Servidor intermediario que distribuye los mensajes publicados en un tópico MQTT a todos los suscriptores de ese tópico.
- **CRUD**: Siglas de create, read, update y delete, operaciones básicas para gestionar registros en una base de datos.
- **DTO**: Objeto que se utiliza para transportar datos entre capas de una aplicación.
- **Mapper**: Componente software que transforma objetos de un tipo origen a otro destino.
- **Microservicio**: Estilo arquitectónico software que consiste en desarrollar aplicaciones mediante colecciones de pequeños
