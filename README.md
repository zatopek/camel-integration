# Spring Integration based Rest api + Camel Spring boot based integration to google maps geocoding connected by ActiveMQ

### Introduction
This is a trivial example implementation to expose a spring integration based rest api to pass in an address as a single string, this string will be used placed on an activemq to be serviced by another service listening on the same queue, which will call the google maps geocoding service, the returned xml is marshalled into a pojo and this pojo is transformed into a simpler pojo and sent back over activemq. The rest api will finally return this pojo in json format to the original caller

### Build

Each of the projects will have to be built with

`mvn clean install`


### Run
You will need to first have an activemq instance running.
You can download a version from <http://activemq.apache.org/activemq-5153-release.html>

After download unzip to any folder of your choice and from the bin folder run

`activemq start`

*Note: This will occupy port 61616*

To run the example, you need to start up the servers in **each** project by typing

	  mvn spring-boot:run

*Note: The server project will run on port 8080 and the source project will run on port 8081*

To stop the server hit <kbd>ctrl</kbd>+<kbd>c</kbd>


The web service endpoint address is:
  <http://localhost:8080/address?query={}>



You can test the web service using rest client like postman or using curl from a command line.

`curl -v http://localhost:8080/address?query=10+10th+Street,+Suite+325 &`