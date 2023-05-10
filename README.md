



# Delpoyment of Microservices in openstack/Bare metal(Computer)

This project is SpringBoot Microservices Backend for Sms Reader Android Application it reads messages from Android Device .
## Swagger Documentation
```bash
To view all rest endpoints, models at one place
Swagger UI - http://172.24.4.99:8085/swagger-ui/index.html

To send request/response from rest endpoint
Get/Post - http://172.24.4.99:8085/dispense/api/mobile

To Get all logs of the application
Logs - http://172.24.4.99:8085/actuator/logfile
```
## How to connect openstack instance
```bash
  ssh idrbt@172.24.4.99
  password:idrbt
```


## Installation  on openstack instance or bare metal

Install Git on openstack Instance

```bash
  sudo apt update
  sudo apt install git
  git -version
  Reference link:https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-22-04
```

Install Java on openstack Instance

```bash
  sudo apt update
  sudo apt install openjdk-17-jre-headless
  java -version
    openjdk version "17.0.6" 
  Reference link:https://www.digitalocean.com/community/tutorials/  how-to-install-java-with-apt-on-ubuntu-22-04
```
Install MongoDB on openstack Instance

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
  mongod --version
  Reference link:https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-20-04
```
How to create Database,Collection,View the Collection in MongoDB

```bash
  mongo
  >show dbs
   admin   0.000GB
   config  0.000GB
   local   0.000GB
   
  above three are default dbs we can create new db using following command
  >use mobileDB
  >switched to db mobileDB
  >show dbs
   admin     0.000GB
   config    0.000GB
   local     0.000GB
   mobileDB  0.000GB
   
   Create MongoDB Collection
   > db.createCollection("mobileDB")
    { "ok" : 1 }
   > show collections
     collection
     mobileDB
    we can find all collections using below command
   > db.getCollectionNames();
    [ "collection", "mobileDB" ]

    we can view all Documents in MongoDB collection
    > db.mobileDB.find()
    { "_id" : 1, "amount" : 600, "account" : "567854335", "txn_status" :      "Success", "message" : "600 UPI amount credited", "_class" : "com.idrbt.lab.dto.Mobile" }
    Reference link:https://linuxhint.com/mongodb-create-collection/

```

Install Maven on openstack Instance

```bash
  We can set the javapath using below commands
    Setting JAVA_HOME and path Environment Varibles
    JAVA_HOME='/opt/jdk-17.0.6'
    PATH="$JAVA_HOME/bin:$PATH"
    export PATH

  Verify the Java Installation
    $ java -version
      openjdk version "17.0.6" 

  Download the Maven Binaries
  $ wget https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.8.6-bin.tar.gz
  $ tar -xvf apache-maven-3.6.3-bin.tar.gz
  $ mv apache-maven-3.8.6 /opt/ 


  Setting M2_Home and Path Varibles
  M2_HOME='/opt/apache-maven-3.6.3'
  PATH="$M2_HOME/bin:$PATH"
  export PATH


  Verify the Maven Installation
  $ mvn -version
  Apache Maven 3.8.6

  Reference link:https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu#step-2-setting-java-_home-and-path-environment-variables
```

## Git Clone
```bash
  https://github.com/pavankumar0077/IDRBT-Microservices.git
  
```
## How to run the application
```bash
 import the project and run the application using follwing steps
 After GitClone the project in instance move to  microservice folder
 1. cd IDRBT-Microservices/
 2. to build the package(jar file)
    mvn package
 3. cd target/
    ls  
 4. To run the SpringBoot application
    java -jar mobile-communication-0.0.1-SNAPSHOT.jar
  
```
## How to test the application
```bash

Get/Post request from Restendpoint

Get Request:
wget http://172.24.2.99:8085/dispense/api/mobile

Post Request:
curl --location --request post 'http://172.24.2.99:8085/dispense/api/mobile' \
--header 'Content-Type: application/json' \
--data '{
"amount":600,
"account":"567854335",
"txn_status": "Success",
"message":"600 UPI amount credited"
}'

output:
{"id":1,"amount":600.0,"account":"567854335","txn_status":"Success","message":"600 UPI amount credited"}
```















    















    





    
