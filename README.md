hibernate-and-jpa
=================

A HelloWorld exercise using, you guessed it, hibernate and jpa.  

This is based heavily on the [hibernate-and-hsqldb](https://github.com/jankenstein/hibernate-and-hsqldb) project and is taken from [Java Persistenct with Hibernate](http://www.amazon.com/gp/product/1932394885/tag=ericjank00-20)

Steps to recreate
=================

1.  Create Maven quickstart application using:

     mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1
     
2.  Copy dependency jars into lib folder for Ant build.  I agree, this is dumb.

3.  Create Message.java file with javax.persistance annotations     

4.  Start HSQLDB :: java -classpath ${PROJECT_DIRECTORY}/lib/hsqldb-2.2.9.jar org.hsqldb.Server (page 63)

5.  Export Schema:  
    
    a.  run `ant schemaexport`
    
    b.  Take a look at the generated helloworld-ddl.sql file

6.  Run main method:
    
    a.  run `ant run`
    
    -- or --
    
    b.  Eclipse: Run As... Java Application
    
7.  Behold the data
    
    -- run `ant dbmanager`
    
    -- in the Swing app execute the following SQL - select * from messages;
    
8.  Profit