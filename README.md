# wait-for-it-mysql

It's a simple project to demonstrate the use of services that need to be up and running before a dependent service starts.

## Installation

Use the maven wrapper to build the image:

```bash
./mvnw clean package
```

Put a ```.env``` file in ```others/docker-compose``` directory to fulfill the environment variables.

```bash
# in others/docker-compose folder
cat <<EOF > .env
MYSQL_PASSWORD=<password>
SPRING_DATASOURCE_PASSWORD=${MYSQL_PASSWORD}
SPRING_DATASOURCE_USERNAME=<username>
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/spring?createDatabaseIfNotExist=true
EOF

docker-compose up
```

## Usage

Just hit http://localhost:8080, and a login page should appear. Use **john/12345** for initial credentials.
