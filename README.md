# BACK-END DEVELOPMENT

-	Click in File > New > Dynamic Web Project > Fill the project name field > Add a runtime by selecting the Java web SDK from SAP Hana Cloud Platforms tools > Next > Next > Check the “Generate web.xml” box
-	Right click on the project > Configure > Convert to Maven Project

# Configuring maven
-	Open the Pom.xml and configure the properties, repositories and dependencies

# Creating the packages
-	com.sap.task.tracker.application
-	com.sap.task.tracker.controller
-	com.sap.task.tracker.dao
-	com.sap.task.tracker.model

# Configuring the Spring framework
-	Open the WebContent/WEB-INF/
-	Create a new file called mvc-dispatcher-servlet.xml
-	Don’t forget to map the packages: application, controller and dao

# Configuring the web.xml
-	Open the WebContent/WEB-INF/web.xml
-	Configure the Spring
-	Configure the Datasource

# Configuring the persistence layer
-	Create a class called PersistenceJPAConfig.java in the com.sap.task.tracker.application package
-	Map the package containing the JPA models

# Creating the model
-	Create a new class called Task in the model package
-	Create three attributes:
  o	id (long)
  o	name (String)
  o	done (Boolean)
-	Create getters/setter methods
-	Add the annotation @Entity above the class definition
-	Add the annotation @id
-	Add the annotation @column(nullable = false) for the name and done attributes

# Creating the DAO
-	Create a new class called TaskDAO in the dao package
-	Add the annotation @Repository above the class definition
-	Create the EntityManager attribute and annotate with @PersistenceContext
-	Create the method to get all the Tasks from the database
-	Create the method to get a task by the id
-	Create the method to persist a new Task
-	Create the method to delete a Task
-	Create the method to update the Task done attribute


# Creating the controller
-	Create a new class called TaskController in the controller package
-	Annotate the class with @Controller and @RequestMapping(“/task”)
-	Declare the TaskDao instance and annotate with @Autowired
-	Create the webservices which will call the methods from the DAO

# Testing locally
-	Create a new Java Web Server
-	Select the SDK if needed
-	Add the project to the server
-	Publish and Start the server

# Deploying to the HCP
-	Create a new SAP Hana Cloud Platform server
-	Change the Landscape host to “hanatrial.ondemand.com”
-	In runtime select the Java Web
-	Fill the fields with your data
-	Add the project to the server
-	Publish
-	Open the HCP cockpit and start the application
