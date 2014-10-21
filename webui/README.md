# A simple Java EE + Vaadin project setup

A simple project setup example for Vaadin + IntelliJ IDEA webinar.

To open the project to your IDE:

 * checkout using GIT or download as zip
 * File->Import the project into IntelliJ, just choose the parent directory and defaults, and most essentially correct SDK for the project ;-)

To build the project:

 * Use "Maven projects" view and execute install on top level project (builds both backend and webui)

Incremental builds can be done right from the IDE.

Deploying to server:

 * Ultimate Edition: create any Java EE server setup from "Run->Edit Configurations". Be sure to use "http://localhost:8080/webui/" as the target url that is opened into browser and and add deployment "webui:war exploded". Then just debug or run. Making project in debug mode automatically replaces changed classes in the server.
 * In community edition, execute maven target "tomee:run" in the webui module. Tomee plugin is preconfigured there.

