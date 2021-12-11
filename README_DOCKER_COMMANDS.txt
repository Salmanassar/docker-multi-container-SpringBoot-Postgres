RUNNING MULTI-CONTAINER JAVA APPLICATION WITH DOCKER COMPOSE


==============Clip 2. Setting up a Database Container==============
OFFICIAL DOCUMENTATION
https://hub.docker.com/_/postgres

EXECUTED COMMANDS
For Linux and Mac:
docker run -it --rm \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=1234 \
  -e POSTGRES_DB=bookdb \
  -v ${PWD}/db:/var/lib/postgresql/data \
  postgres

docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=bookdb -v ${PWD}/db:/var/lib/postgresql/data postgres
if data directory “/var/lib/postgresql/data” has invalid permissions change permission or address (for example ${PWD}/db:postgresql)
 
For Windows CMD:
docker run -it --rm ^
  -p 5432:5432 ^
  -e POSTGRES_PASSWORD=1234 ^
  -e POSTGRES_DB=bookdb ^
  -v %cd%/db:/var/lib/postgresql/data ^
  postgres
_____________________________________________________________________________________________________________________________
in one line (Windows)
docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=bookdb -v %cd%/db:postgresql postgres
--------------------------------------------------
./gradlew clean bootRun
# Or
./mvnw spring-boot:run
--------------------------------------------------
./gradlew clean build
# Or
./mvnw clean package
--------------------------------------------------
docker build -f web.Dockerfile -t web-app .
--------------------------------------------------
docker run -it --rm -p 8080:8080 web-app



==============Clip 3. Setting up a Docker Network==============
OFFICIAL DOCUMENTATION
Networking overview
https://docs.docker.com/network/

docker network command reference
https://docs.docker.com/engine/reference/commandline/network/

EXECUTED COMMANDS
docker network create web-db
--------------------------------------------------
docker network ls
--------------------------------------------------
docker network inspect web-db
--------------------------------------------------
For Linux and Mac:
docker run -it --rm \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=1234 \
  -e POSTGRES_DB=bookdb \
  -v ${PWD}/db:/var/lib/postgresql/data \
  --net web-db --name db postgres

docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=bookdb -v ${PWD}/db:postgresql --net web-db --name db postgres

For Windows CMD:
docker run -it --rm ^
  -p 5432:5432 ^
  -e POSTGRES_PASSWORD=1234 ^
  -e POSTGRES_DB=bookdb ^
  -v %cd%/db:/var/lib/postgresql/data ^
  --net web-db --name db postgres
--------------------------------------------------
docker run -it --rm -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=bookdb -v %cd%/db:postgresql --net web-db --name db postgres
--------------------------------------------------
docker network inspect web-db
--------------------------------------------------
docker build -f web.Dockerfile -t web-app-db .
--------------------------------------------------
docker run -it --rm -p 8080:8080 --net web-db web-app-db



==============Clip 4. Using Docker Compose==============
OFFICIAL DOCUMENTATION
Overview of Docker Compose
https://docs.docker.com/compose/

Compose file reference
https://docs.docker.com/compose/compose-file/

Control startup and shutdown order in Compose
https://docs.docker.com/compose/startup-order/

wait-for-it
https://github.com/vishnubob/wait-for-it

EXECUTED COMMANDS
cp web.Dockerfile web-wait.Dockerfile



==============Clip 5. Managing Docker Compose Services==============
OFFICIAL DOCUMENTATION
Compose command-line reference
https://docs.docker.com/compose/reference/

EXECUTED COMMANDS
docker-compose config
--------------------------------------------------
docker-compose config -q
--------------------------------------------------
docker-compose build
--------------------------------------------------
rm -r db
--------------------------------------------------
docker-compose up
--------------------------------------------------
docker container ls
--------------------------------------------------
docker network ls
--------------------------------------------------
docker-compose ps
--------------------------------------------------
docker-compose top
--------------------------------------------------
docker-compose kill
--------------------------------------------------
docker container ls -a
--------------------------------------------------
docker-compose rm
--------------------------------------------------
docker container ls -a
--------------------------------------------------
docker-compose up -d
--------------------------------------------------
docker-compose stop
--------------------------------------------------
docker-compose start
--------------------------------------------------
docker-compose down
--------------------------------------------------
docker-compose down --rmi all
