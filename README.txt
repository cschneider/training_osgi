h1. Overview

Template for OSGi training.
Use this as a starting point when solving the training tasks.

h1. Structure

features
  template for a feature file and project to deploy it

itest
  template for integration tests. Already contains the pax exam dependencies

h1. Build

mvn clean install

h1. Installation

features:addurl mvn:net.lr.training/training-features/1.0.0-SNAPSHOT/xml
features:install training

h1. Excercises

Hints:
- See the snippets dir for some templates for your blueprint files
- Most of the things you need can be found in one of the karaf tutorials: http://liquid-reality.de/display/liquid/Karaf+Tutorials

h2. 1. First OSGi service

Create an OSGi service based on the existing model. 

- Create a new module named service that uses the model project
- Add a service implementation using the simplest possible in memory persistence 
- and a blueprint file to export the service impl as an OSGi service
- Add the bundles to run your service to the existing feature file
- Test your service in karaf. Install the feature and verify the OSGi service is published

Hints: 
- Make sure the packaging for the service module is "bundle"
- Before creating the feature you can test your bundles by installing them separately using install -s mvn:groupid/artifactid/version 

h2. 2. Integration Test

Create an integration test using pax exam that tests your service 

- Use the existing module itest
- Change the test class to install your service feature, call your service and check the result 
- Run the test and verify it works correctly

Hints: 
- The first test run needs to be done using mvn install to create the dependencies file for pax exam .versionAsInProject() after that you can 
run tests from eclipse usign run as junit test 

h2. 3. Create a servlet UI that uses the OSGi service

- Create a module ui that implements a HTTPServlet and that uses your OSGi service to display some informations about the service
- add a feature for the UI
- Test the UI and service in kataf. Install the features and verify that you can access the UI

Hint:
- For the servlet API use version 2.5 : See https://github.com/cschneider/Karaf-Tutorial/blob/master/tasklist/tasklist-ui/pom.xml
- Use pax web and the whiteboard pattern to export your servlet impl as an OSGi service. See https://ops4j1.jira.com/wiki/display/ops4j/Pax+Web+Extender+-+Whiteboard 

h2. 4. Create a CXF Rest endpoint that uses your service
 
- Create a module named endpoint that implements a CXF rest endpoint and exports it using blueprint and the cxf rest namespace
- Add a feature for the new module
- Test the feature in karaf and verify the rest endpoint is visible
- Call the rest endoint using e.g. poster or SOAP UI
- Optional: Add a pax exam test that calls your rest service

Hints:
- The karaf tutorial about CXF implements a SOAP and a REST endpoint. Only take the rest parts from it
- Best use a new rest impl class that delegates to your OSGi service
- Use the servlet transport for CXF. So set your address simply to /yourpath
- Check the CXF services page to see if your service is published: http://localhost:8181/cxf

h2. 5. Create a camel route that uses your service

- Create a module named route with a camel route
- The route starts with a file endpoint, extracts some information from the file, calls your service and stores the result in a new file.

Hints:
- Use a relative path name for the file endpoint. It will start at the karaf dir

h2. 6. Change the camel route to offer a rest service

- Change the module route to now listen to a cxfrs endpoint, call your service and returns the result

Hints:
- See here for documentations about the camel cxfrs component: http://camel.apache.org/cxfrs.html
- You need to specify an empty impl class to the cxfrs config. The interface alone is not enough
- Camel does not actually use the impl it just reads the Rest annotations
- Beware of java List it does not directly work as return in a rest interface. Use an array instead

h2. 7. Use jpa persistence inside your service

Make your service persist some data using jpa. Use the "Apache Karaf Tutorial Part 6 - Database Access" project db_examplejpa as an example for how to setup your project.
- Use openjpa and derby as jpa backend

Hints:
- First try to compile, install and understand the tutorial before you apply it to your own code
- Use the featue openjpa in the existing feature file to load openjpa
- Openjpa needs compile time enhancements which are done using a maven plugin
- Add JPA annotations to your service DTO class. This is easier than completely mapping the DTO class to JPA   

h2. Optional: 8. Switch your persistence to hibernate

Same as above but now use hibernate as backend and use the hibernate Session instead of the EntityManager.
Use the hibernate project in the db tutorial source as an example how to swithc to hibernate and how to create a feature for hibernate.
