# Spring Integration based Rest api

### Introduction
This is a trivial example implementation to expose a spring integration based rest api to pass in an address as a single string. After requesting the address to be cleaned up over activemq by a remote service, the rest api will finally return this pojo in json format to the original caller

### Build

The project can be built with

`mvn clean install`


### Run
You will need to first have an activemq instance running.
You can download a version from <http://activemq.apache.org/activemq-5153-release.html>

After download unzip to any folder of your choice and from the bin folder run

`activemq start`

*Note: This will occupy port 61616*

To run the example, you need to start up the servers in **each** project by typing

`mvn spring-boot:run`

*Note: The server project will run on port 8080 and the source project will run on port 8081*

To stop the server hit <kbd>ctrl</kbd>+<kbd>c</kbd>


The web service endpoint address is:
  <http://localhost:8080/address?query={}>



You can test the web service using rest client like postman or using curl from a command line.

`curl -v http://localhost:8080/address?query=10+10th+Street,+Suite+325 &`