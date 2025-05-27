# Docker Build Instructions

This guide explains how to build Docker images for the frontend, backend, and database services.

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/) installed on your machine
- Source code and Dockerfiles for each service

## Build Images

### 1. Frontend

Navigate to the frontend directory (where the Dockerfile is located) and run:

```sh
docker build -f Dockerfile.frontend -t custom-frontend:1.0.0 .
```

### 2. Backend

Navigate to the backend directory and run:

```sh
docker build -f Dockerfile.backend -t custom-backend:1.0.0 .
```

### 3. Database

Navigate to the directory containing your MySQL Dockerfile and run:

```sh
docker build -f Dockerfile.mysql -t custom-mysql:1.0.0 .
```

## Using Docker Compose

After building the images, you can start all services using:

```sh
docker-compose up
```

or, if your compose file is not named `docker-compose.yml`:

