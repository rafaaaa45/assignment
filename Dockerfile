# Step 1: Use Tomcat base image with JDK 17 (OpenJDK 17 and Tomcat 9)
FROM tomcat:9.0-jdk17-openjdk-slim

# Step 2: Set the working directory in the container where WAR files are deployed
WORKDIR /usr/local/tomcat/webapps

# Step 3: Copy your WAR file from the Maven target directory into the Tomcat webapps directory
COPY target/*.war /usr/local/tomcat/webapps/app.war

# Step 4: Expose port 8181 (Tomcat's port will be mapped to 8181)
EXPOSE 8181

# Step 5: Modify the Tomcat config to run on port 8181
RUN sed -i 's/8080/8181/g' /usr/local/tomcat/conf/server.xml

# Step 6: Start Tomcat and deploy the WAR file
CMD ["catalina.sh", "run"]
