# JavaEE Project - Web ToDo List

This was a project in my M1 engineering class, and my first project in JavaEE.

The idea of the deployment in this case was to prepare the « war » (web archive) file. This file is what we need to put on the server that will host the application.



## instructions

To create the war file, you have to export your project into war file : right click on the project → export → war file. You choose the destination, you check the « Export source files » and
 « Overwrite existing file » and you click ok. You will find this war file in the destination that you choosed and that's it.

To test the deployment, go to eclipse. Open the servers tab, expand the server that you use for the application, remove your project from the server's list of applications and close eclipse.

Now, Try to run the application from the browser without using eclipse. You will see that you will not be able to run it because eclipse,the only link between the application and tomcat, is closed.

To solve the problem, you need to put the war file in the « webapps » folder of tomcat.

- Go to your Tomcat folder → webapps folder → paste the war file inside

- Start Tomcat : Go to the Tomcat Folder → bin → startup.bat

- Open your browser → tape the url of your project → you will have the start page of your

  project. So now it runs.

  For more details, please refer to the link below :

  http://sdz.tdct.org/sdz/creez-votre-application-web-avec-java- ee.html#Empaquetageetdploiementd039unprojet

  **Remark:**

  Tomcat is a real application server and not a virtual one. An application server is a software that should be installed on the server that will execute the web application. That's why we installed tomcat on our machines. What we have done in this course, is to consider our machine as a local server that hosts the application (localhost). To excute the application, our local server uses tomcat (application server) and mysql (data server). 
