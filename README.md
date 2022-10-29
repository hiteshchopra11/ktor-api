# KtorAPI

KtorAPI is a project which demonstrates the power of Kotlin's Ktor in developing powerful REST APIs with all basic as well as advanced features.

## Architecture
Ktor Controller (http) -> Service (business) -> Repository (data)
## Features
1. Create Notes
2. Update Notes
3. Fetch Notes
4. Delete Notes
5. JWT Authentication
6. Ktorm ORM for DB
7. Dependency Injection using Koin
8. Pagination

#### Coming soon -:

1. Sorting results using parameters
2. Unit Testing
3. Middlewares for Validations
4. Searching
5. Exporting data in excel format
6. Exporting data in csv format


## Installation

Use IntelliJ IDEA, community or enterprise edition to open the project and follow [these steps](https://ktor.io/docs/intellij-idea.html#run_app) to run the Application.

Notes -: Customise the application.conf file which is not included with the project for security reasons. Specify the ktor object in the application.conf file and fill your own secret, audience, issuer, realm to configure the [JWT authenticaton settings](https://ktor.io/docs/jwt.html#jwt-settings). Similarly,specify your port and host inside the [application.conf](https://ktor.io/docs/configurations.html#hocon-file) file in which you want to run the server.

Start the MySQL server to use the notes API.

## Usage
### Notes API

1. ##### Create a new note
```http
POST http://0.0.0.0:3536/notes
Content-Type: application/json

{
  "note": "your-note",
}
```

2. ##### Fetch all notes
```http
GET http://0.0.0.0:3536/notes
```

3. ##### Fetch a particular note
```http
GET http://0.0.0.0:3536/notes/{id}
```

4. ##### Delete a particular note
```http
DELETE http://0.0.0.0:3536/notes/{id}
```

5. ##### Update a particular note
```http
PUT http://0.0.0.0:3536/notes/{id}
```

6. ##### Fetch paginated notes
```http
GET http://0.0.0.0:3536/paginatedNotes?size=5&page=1
```

### JWT Authentication

1. ##### Generate an Auth Token
```http
POST http://0.0.0.0:3536/generate-token
Content-Type: application/json

{
  "username": "username",
  "password": "password"
}
```

2. ##### Test the Auth token
```http
GET http://0.0.0.0:3536/test
Authorization: Bearer {{auth_token}}
```
