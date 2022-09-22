# Getting Started

You will need to have IntelliJ (or Eclipse) installed. 
Any version of IntelliJ is fine to use. 

0. Clone this repoo
1. Download / install Intellij (https://www.jetbrains.com/idea/download/)
2. Launch IntelliJ
3. Either from the launch screen or file menu, select open or import
4. Select the folder CONTAINING the build.gradle file in the repo

# Running the Test Web Application

1. Right-click on WallApplication->Run WallApplication
2. Open a browser to http://localhost:8080/post
3. Try entering comments in that create XSS vulnerabilities when submitted to the server
4. In IntelliJ, press the red square to stop the application.

# Instructions

See the src/main/java/edu.vanderbilt.wall.wall.WallController for directions.

First, you will try to make a safe filter for comments
with HTML.

Then, you will try to break someone else's filter.

# Common Errors

If you see:

```
Web server failed to start. Port 8080 was already in use.

Action:

Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.


Process finished with exit code 1
```
You need to go into IntelliJ, find the red stop square and press it to terminate the process. Only one instance of
the application can be running at a time. 
