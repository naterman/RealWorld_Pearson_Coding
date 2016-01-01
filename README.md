<!--
This README intends to be a starter template for the Pearson Student Coding Contest. Feel free to add or omit content as needed for your app. The formatting is done using Markdown. These comment sections are simply guides that you can delete.
-->

# "RealWorld"


<!--
The "App Overview" section intends to be a high level description of your app. Think of what you might want to know if considering a purchase in an app store. 
-->

## App Overview

"My Contest App" enables students to control notifications related to their classes from their cell phone. This improves their awareness of assignments and due dates through customizable alerts. It is proven that today's students are more tech savvy than ever. They expect to interact with classes in the same way as their social networks. "My Contest App" makes courses more mobile and social by doing something remarkable...

### Planning

[See this project's hackathon entry page!](http://www.hackathon.io/pearson)

### Demo

[Watch a video of the application in action!](https://www.youtube.com/watch?v=8BFMaQjrw4s)

### Screenshots

![Login Screenshot](http://developer.pearson.com/sites/default/files/LSDashboard_Login_small.png)
![Launch Screenshot](http://developer.pearson.com/sites/default/files/LSDashboard_NewActivity_small.png)
![Settings Screenshot](http://developer.pearson.com/sites/default/files/LSDashboard_Settings_small.png)


<!--
The "App Details" section intends to explain how your app works. Describe the major components, what APIs were used, and what is missing to make this production ready.
-->

## App Details

"My Contest App" utilizes a 3rd party messaging system to keep classmates alerted of assignments. This was chosen over text messages and push notifications because of the great selection of emoji and meme support.

### API Usage

 * [3rd Party Messaging API](#) - provides communication services
 * [LearningStudio API](http://developer.pearson.com/learningstudio/course-apis/course-info/enrollment/reference) - provides class schedules and rosters
 * [LearningStudio Eventing](http://developer.pearson.com/learningstudio/receive-events) - provides realtime notifications of class happenings

### Scope of Functionality 

This application is mostly functional. The number of users able to use this application is limited by shortcuts taken for data storage. These were necessary to finish by the deadline, but replacing the temporary data store with a more scaleble solution would make this application ready for prime time!

<!--
The "Prerequisites" section intends to assist someone get started with your source code. They might not be familar with your frameworks or project structure. Help them out by explaining what you already know. 
-->

## Prerequisites

### Build Environment 

 * XCode 6.3.1 is required.
 * Swift 1.2 is required
 * Java 7 or greater is required
 * Maven 2 is required

### Server Environment 

 * Any app server supporting the Java 2.5 Servlet Specification

<!--
The "Installation" section intends to assist someone deploy your project themselves. What do they need to configure, package, and distribute?
-->

## Installation

### Application Configuration

JavaServer/MyContestApp/src/main/resources/LearningStudio.properties

~~~~~~~~~~~~~~
application_id={Application Id}
client_string={Client String}
~~~~~~~~~~~~~~

iOS/MyContestApp/LearningStudio.plist

~~~~~~~~~~~~~~
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
    <key>app_id</key>
    <string>{Application Id}</string>
    <key>client_string</key>
    <string>{Client/Environment Identifier}</string>
</dict>
</plist>
~~~~~~~~~~~~~~

### Application Deployment

#### Build

Java Server

~~~~~~~~~~~~~~
cd server
mvn clean package
~~~~~~~~~~~~~~

iOS App - build with xCode


#### Deploy 

Java Server - copy target/my-contest-app.war to the server

iOS App - run in emulator

<!--
The "Credit" section intends to highlight your team. Tell who contributed to what parts of the project. Give thanks to mentors that were helpful.
-->

## Credit

### Team

This project was a collaborative effort. We are all classmates in CS101 at Cool University.

 * [Jill Doe](#) - marketing and presentation
 * [Joe Doe](#) - graphics and videos
 * [Jane Doe](#) - iOS application
 * [John Doe](#) - java server application

### Other

This project would not have been possible without [Professor Smith](#) and [Doctor Jones](#). They informed us of the coding contest and acted as mentored during the entire process.

<!--
The "License" section intends to be a license declaration. Checkout choosealicence.com to become familar with different licences. The full license should be included in the LICENSE file, but you can also declare and link to it here.
-->

## License

My Chosen License

~~~~~~~~~~~~~~
http://choosealicense.com/
~~~~~~~~~~~~~~
