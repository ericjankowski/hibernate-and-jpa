hibernate-and-jpa
=================

A HelloWorld exercise using, you guessed it, hibernate and jpa.  

This is based heavily on the [hibernate-and-hsqldb](https://github.com/jankenstein/hibernate-and-hsqldb) project.

Steps to recreate
=================

1.  Create Maven quickstart application using:

     mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1
     
2.  Copy dependency jars into lib folder for Ant build.  I agree, this is dumb.

3.  Create Message.java file with javax.persistance annotations     