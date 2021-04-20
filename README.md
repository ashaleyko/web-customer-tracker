This is old-school XML-based Spring MVC and Hibernate CRUD application demonstration with JSP frontend

## Prerequisites

* MySQL
* Tomcat
* Intellij IDEA

## Installation

* Pull out the code using [Git](https://git-scm.com/downloads):

```shell
https://github.com/ashaleyko/web-customer-tracker.git
cd web-customer-tracker
```
* Run the database scripts to create a user and load sample data  
  a. resources/sql/01-create-user.sql  
  b. resources/sql/02-customer-tracker.sql

## Usage

* Add WAR artifact setup in Intellij IDEA:
Project Structure -> Artifacts -> Add -> Web Application: Exploded -> From Modules -> web-customer-tracker.main

* Add Tomcat Server configuration and select artifact for deployment from previous step

* Run Tomcat Server configuration 

## Demo
Create  
![Alt text](src/main/resources/screenshots/web-customer-tracker-save.png?raw=true "Save")

Read  
![Alt text](src/main/resources/screenshots/web-customer-tracker-list.png?raw=true "List")

Update  
![Alt text](src/main/resources/screenshots/web-customer-tracker-update.png?raw=true "Update")

Delete  
![Alt text](src/main/resources/screenshots/web-customer-tracker-delete.png?raw=true "Delete")
