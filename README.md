ProductLister
=============

Info & Technologies
===================
This is a REST backend for an Android application.
SpringBoot is used to run the application and Jackson is used for converting
data to and back from JSON format.
The system uses Hibernate to connect to a MySQL database and store entities.
SpringBoot uses integrated Tomcat server for running the application.
The development IDE was Netbeans 8.0.1

Requirements
============
Java 8
Maven for building
A MySQL databse running in localhost, connection details in persistance.xml

Installation
============
1) Build with mvn install

2) If the build is succesful there should be a productlister.jar in the target
folder. This file can be run with the command 'java -jar productlister.jar' or
by using start.sh

3) The server should now be running at http://localhost:8080/ and for example
listing all available products you request http://localhost:8080/data/products
