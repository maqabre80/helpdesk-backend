# Help Desk API REST — Backend

Sistema de Gestión de Incidentes (Help Desk) — API RESTful construida con
Spring Boot (Java) y MongoDB Atlas.

**Autor:** Fausto Damian Guano Loya
**Universidad:** Universidad Técnica de Manabí
**Materia:** Desarrollo de Sistemas Informáticos — Unidad 4
**Actividad:** #8 — Desarrollo del Backend y Base de Datos

---

## Tecnologías utilizadas

| Tecnología | Versión | Función |
|---|---|---|
| Java | 26.0.2 | Lenguaje de programación |
| Spring Boot | 3.3.0 | Framework para API REST |
| Spring Data MongoDB | 3.3.0 | ODM — operaciones CRUD automáticas |
| MongoDB Atlas | Cloud M0 | Base de datos documental en la nube |
| Maven | 3.x | Gestor de dependencias |
| Postman | Desktop | Pruebas de endpoints |

---

## Estructura del proyecto
backend-api/
├── src/
│ └── main/
│ ├── java/com/utm/backend_api/
│ │ ├── BackendApiApplication.java ← Punto de entrada
│ │ ├── controller/
│ │ │ └── TicketController.java ← Endpoints REST (separado)
│ │ ├── model/
│ │ │ └── Ticket.java ← Modelo de datos (separado)
│ │ └── repository/
│ │ └── TicketRepository.java ← Acceso a MongoDB
│ └── resources/
│ └── application.properties ← Configuración
└── pom.xml ← Dependencias Maven


---

## Variables de entorno y credenciales

Las credenciales de conexión se configuran en
`src/main/resources/application.properties`:

```properties
# Puerto del servidor
server.port=8080

# Conexión a MongoDB Atlas
# IMPORTANTE: Reemplazar con sus propias credenciales
spring.data.mongodb.uri=mongodb+srv://<USUARIO>:<PASSWORD>@<CLUSTER>.mongodb.net/<DATABASE>
spring.data.mongodb.database=helpdesk
spring.application.name=backend-api
```

> ⚠️ **Nunca subir credenciales reales al repositorio.**
> Para producción usar variables de entorno del sistema o archivo `.env`.

### Variables necesarias para ejecutar el proyecto:

| Variable | Descripción | Ejemplo |
|---|---|---|
| `spring.data.mongodb.uri` | Cadena de conexión a MongoDB Atlas | `mongodb+srv://user:pass@cluster.mongodb.net/helpdesk` |
| `server.port` | Puerto del servidor | `8080` |

---

## Instalación y ejecución local

```bash
# 1. Clonar el repositorio
git clone https://github.com/maqabre80/helpdesk-backend.git
cd helpdesk-backend

# 2. Configurar credenciales en:
# src/main/resources/application.properties

# 3. Ejecutar con Maven
.\mvnw spring-boot:run

# 4. Verificar que el servidor está corriendo
# Abrir: http://localhost:8080/api/tickets
```

---

## Endpoints de la API

Base URL: `http://localhost:8080/api`

| Método | Endpoint | Descripción | Status |
|---|---|---|---|
| GET | /tickets | Lista todos los tickets | 200 OK |
| GET | /tickets/{id} | Obtiene un ticket por ID | 200 OK |
| POST | /tickets | Crea un nuevo ticket | 201 Created |
| PUT | /tickets/{id} | Actualiza un ticket | 200 OK |
| DELETE | /tickets/{id} | Elimina un ticket | 200 OK |

---

## Modelo de datos — Ticket

```json
{
  "id":          "string (automático MongoDB)",
  "titulo":      "string (requerido)",
  "descripcion": "string (requerido)",
  "categoria":   "Red | Hardware | Software",
  "prioridad":   "Alta | Media | Baja | Critica",
  "estado":      "Abierto | En Progreso | Resuelto",
  "tecnico":     "string (default: Por Asignar)",
  "fecha":       "date (automática)"
}
```

---

## Diseño estructurado — Separación de responsabilidades

El proyecto sigue la arquitectura **MVC en capas**:

| Capa | Clase | Responsabilidad |
|---|---|---|
| **Modelo** | `Ticket.java` | Define la estructura de datos y mapeo a MongoDB |
| **Repositorio** | `TicketRepository.java` | Acceso a datos — operaciones CRUD automáticas |
| **Controlador** | `TicketController.java` | Lógica HTTP — recibe requests y devuelve responses |

---

## Control de versiones — Gitflow

| Rama | Propósito |
|---|---|
| `main` | Rama de producción estable |
| `develop` | Rama de integración continua |
| `feature/backend-api` | Desarrollo de la API REST |

---

## Repositorios GitHub

- **Backend:** https://github.com/maqabre80/helpdesk-backend
- **Frontend:** https://github.com/maqabre80/helpdesk-frontend
Guarda con Ctrl + S.

PASO 2 — Subir el README.md a GitHub
powershell
cd C:\Users\Windows\Documents\Prototipo\backend\backend-api
git add README.md
git commit -m "docs: README.md con credenciales, estructura y guía de ejecución"
git push origin main
git push origin develop
git push origin feature/backend-api
Mándame captura cuando termine el push y luego actualizo el documento de la Actividad 8 con el README incluido.



---

## Variables de entorno y credenciales

Las credenciales de conexión se configuran en
`src/main/resources/application.properties`:

```properties
# Puerto del servidor
server.port=8080

# Conexión a MongoDB Atlas
# IMPORTANTE: Reemplazar con sus propias credenciales
spring.data.mongodb.uri=mongodb+srv://<USUARIO>:<PASSWORD>@<CLUSTER>.mongodb.net/<DATABASE>
spring.data.mongodb.database=helpdesk
spring.application.name=backend-api
```

> ⚠️ **Nunca subir credenciales reales al repositorio.**
> Para producción usar variables de entorno del sistema o archivo `.env`.

### Variables necesarias para ejecutar el proyecto:

| Variable | Descripción | Ejemplo |
|---|---|---|
| `spring.data.mongodb.uri` | Cadena de conexión a MongoDB Atlas | `mongodb+srv://user:pass@cluster.mongodb.net/helpdesk` |
| `server.port` | Puerto del servidor | `8080` |

---

## Instalación y ejecución local

```bash
# 1. Clonar el repositorio
git clone https://github.com/maqabre80/helpdesk-backend.git
cd helpdesk-backend

# 2. Configurar credenciales en:
# src/main/resources/application.properties

# 3. Ejecutar con Maven
.\mvnw spring-boot:run

# 4. Verificar que el servidor está corriendo
# Abrir: http://localhost:8080/api/tickets
```

---

## Endpoints de la API

Base URL: `http://localhost:8080/api`

| Método | Endpoint | Descripción | Status |
|---|---|---|---|
| GET | /tickets | Lista todos los tickets | 200 OK |
| GET | /tickets/{id} | Obtiene un ticket por ID | 200 OK |
| POST | /tickets | Crea un nuevo ticket | 201 Created |
| PUT | /tickets/{id} | Actualiza un ticket | 200 OK |
| DELETE | /tickets/{id} | Elimina un ticket | 200 OK |

---

## Modelo de datos — Ticket

```json
{
  "id":          "string (automático MongoDB)",
  "titulo":      "string (requerido)",
  "descripcion": "string (requerido)",
  "categoria":   "Red | Hardware | Software",
  "prioridad":   "Alta | Media | Baja | Critica",
  "estado":      "Abierto | En Progreso | Resuelto",
  "tecnico":     "string (default: Por Asignar)",
  "fecha":       "date (automática)"
}
```

---

## Diseño estructurado — Separación de responsabilidades

El proyecto sigue la arquitectura **MVC en capas**:

| Capa | Clase | Responsabilidad |
|---|---|---|
| **Modelo** | `Ticket.java` | Define la estructura de datos y mapeo a MongoDB |
| **Repositorio** | `TicketRepository.java` | Acceso a datos — operaciones CRUD automáticas |
| **Controlador** | `TicketController.java` | Lógica HTTP — recibe requests y devuelve responses |

---

## Control de versiones — Gitflow

| Rama | Propósito |
|---|---|
| `main` | Rama de producción estable |
| `develop` | Rama de integración continua |
| `feature/backend-api` | Desarrollo de la API REST |

---

## Repositorios GitHub

- **Backend:** https://github.com/maqabre80/helpdesk-backend
- **Frontend:** https://github.com/maqabre80/helpdesk-frontend