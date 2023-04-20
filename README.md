
# Spring boot microservice project

This project is based on restful microservice with mongodb connectivity and implementation of GET,POST,PUT,DELETE operations or CRUD operations with logging-slf4j implementation,swagger 3 documentation


## Installation

Install Java on Ubuntu

```bash
  sudo apt update
  sudo apt install default-jre
  javac -version
  Reference link:https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-22-04
```
Install Eclipse on Ubuntu

```bash
  https://spring.io/tools
```
Install Postman on Ubuntu

```bash
  https://www.postman.com/downloads/
```
Install MongoDB on Ubuntu

```bash
  curl -fsSL https://www.mongodb.org/static/pgp/server-4.4.asc | sudo apt-key add -
  apt-key list
  echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/4.4 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.4.list
  sudo apt update
  sudo apt install mongodb-org
  sudo systemctl start mongod.service
  sudo systemctl status mongod
  sudo systemctl enable mongod
  mongo --eval 'db.runCommand({ connectionStatus: 1 })'
  Reference link:https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-20-04
```
Install MongoDB Compass on Ubuntu

```bash
  wget https://downloads.mongodb.com/compass/mongodb-compass_1.28.4_amd64.deb
  sudo apt install ./mongodb-compass_1.28.4_amd64.deb
  sudo dnf install -y https://downloads.mongodb.com/compass/mongodb-compass-1.26.1.x86_64.rpm
  mongodb-compass
  Reference link:https://www.digitalocean.com/community/tutorials/how-to-use-mongodb-compass
```
## Git Clone


```bash
  https://github.com/pavankumar0077/IDRBT-Microservices.git
  
```
## How to run the application


```bash
  Right click on project run as springboot application
  
```







    
