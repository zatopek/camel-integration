# Camel Spring boot based integration to google maps geocoding

### Introduction
This example will respond to messages on a queue, the body of the message will have a string representation of an address, this address will be queried against google maps geocoding api and the response will be parsed into an easy to digest form before being returned back.

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

`mvn spring-boot:run`

*Note: The server project will run on port 8080 and the source project will run on port 8081*

To stop the server hit <kbd>ctrl</kbd>+<kbd>c</kbd>
