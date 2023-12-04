# Bookstore

Bookstore is a simple Spring Boot Application made for a university assignment. This is a backend application, and it
only provides a REST API. **There is no UI**. Bookstore provides API for CRUD operations with books, receipts and
invoices.

## Running Bookstore locally

```sh
git clone https://github.com/SirPersimmon/bookstore.git
cd bookstore
```

### With maven command line

```sh
./mvnw spring-boot:run
```

### With Docker

```sh
docker compose up -d
```

You can then access Bookstore here: [http://localhost:8080/api/v1](http://localhost:8080/api/v1)

## Security configuration

In its default configuration, Bookstore has authentication and authorization enabled. In order to access APIs basic
authentication is required. Apart from authentication, APIs also require authorization. This is done via roles that a
user can have. There are two roles: `ADMIN` with full access and `USER` with access to all APIs except for user
management. There is an existing user with the username `admin` and password `admin` that has access to all APIs.
