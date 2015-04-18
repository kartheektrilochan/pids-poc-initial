Configuration and Installation

1.Execute the scripts in sqlscripts folder
	a.schema-creation.sql is for creating the user and schema
	b.pids-scripts.sql for creating all the tables for required for project.

2.Go to database.properties in resource folder for db connection details.


3.All the rest service urls are given in PidsCommonConstants.java file
4.MainClientTest.java can be used Registration service for time being.






















Issues:

org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean has caused some issue as tis was used in hibernates 3
using org.springframework.orm.hibernate4.LocalSessionFactoryBean insted