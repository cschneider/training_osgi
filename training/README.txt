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

h2. 1. Create your first OSGi service

- Create a module named model that contains the service interface and the shared classes.
- Create a module named service that contains the service implementation and that uses blueprint to export the service impl as
an OSGi service
- Create a feature for your service
- Test your service in karaf. Install the feature and verify the OSGi service is published 

h2. 2. Create a servlet UI that uses the OSGi service

- Create a module ui that implements a HTTPServlet and that uses your OSGi service to display some informations about the service
- add a feature for the UI
- Test the UI and service in kataf. Install the features and verify that you can access the UI

h2. 3. Create an integration test using pax exam that tests your service

- Use the preexisting module itest
- Change the test class to install your service feature, call your service and check the result 
- Run the test and verify it works correctly

h2. 3. Create a CXF Rest endpoint that uses your service
 
- Create a module named endpoint that implements a CXF rest endpoint and exports it using blueprint and the cxf rest namespace
- Add a feature for the new module
- Test the feature in karaf and verify the rest endpoint is visible
- Call the rest endoint using e.g. poster or SOAP UI

h2. 4. Create a camel route thagt uses your service

- Create a module named route with a camel route
- The route starts with a file endpoint, extracts some information from the file, calls your service and stores the result in a new file.

h2. 5. Change the camel route to offer a rest service

- Change the module route to now listen to a cxfrs endpoint, call your service and returns the result

