![image](https://travis-ci.org/viktornar/currdiff.svg?branch=master)

CurrDiff - simple web page application
===================
CurrDiff is a simple web page application that can be used for getting exchange rate changes by using remote Lithuanian National Bank service.

The main technologies (frameworks, libraries) that was used in project
-------------
- Embedded Tomcat – For development process speedup embedded tomcat was used. Currently I use IDEA community edition that can’t run a web application using Tomcat Server. The simplest way to bypass this restriction is just write helper class with main method that runs embedded Tomcat server;
- Maven – For project management maven was used. Maven handles dependencies management for project and it can be used for task execution (war packaging, removing libraries in package stage, copying resources while project is building etc.). Gradle as alternative exist, but on my computer project building is much quicker with maven than Gradle. In project Maven wrapper was used. So every user who would like to quickly test application can run project even if maven and tomcat isn’t installed on computer.
- JSF – JavaServer Faces technology was used. JSF allows creating reusable components in the web application. JSF 2 (Mojarra implementation) with facelets templating was used for creating UI of application.
- Prime Faces – Prime Faces was used as JSF component library. Prime Faces has well designed collection of components that can be used in existing project on top of JSF. So if you need to quickly write application with nice looking UI its natural choice to use it. Prime Faces have a lot of themes and one of them (bootstrap) can be quite well integrated with Bootstrap css library.
- Bootstrap – For quick UI mockup Bootstrap was used. Bootsrap allows creating well looking responsive UI.  Bootstrap 3 was used as the latest stable version.
- Spring Framework – Spring framework was used for dependency injection and other service layer oriented tasks (e.g. Rest Template for communication with remote service);
- Junit for testing, BeanUtils for manipulation with Java beans (copying of properties), slf4j for logging, Lombok for syntactic sugar, Xstream and Jackson for marshaling objects from remote service.

> **Note:**

> - Project was written by using Java SDK 1.8. Source was compiled with Java 1.7 compatibility so project should run if Java SDK 1.7  is installed.
> - Java 1.6 and earlier versions is not supported. 
> - Tomcat 7, 8 only supported.