<!--
This README intends to be a starter template for the Pearson Student Coding Contest. Feel free to add or omit content as needed for your app. The formatting is done using Markdown. These comment sections are simply guides that you can delete.
-->

# RealWorld


<!--
The "App Overview" section intends to be a high level description of your app. Think of what you might want to know if considering a purchase in an app store. 
-->

## App Overview

Have you ever visited an airplane museum? There is usually some form of simulation, such as a flight simulator. Those few seconds you were able to experience the cockpit of an F-16. You flew around feeling free as a bird, and if you happen to crash, you never had to pay the consequences, you were just a restart away from flying again. This is the idea behind Project RealWorld. RealWorld aims to bring real world simulation to the classroom, where if something goes wrong, there is no real world consequences.
A student can memorize and regurgitate information; however, if they fail to understand the concept or theory, they will struggle to implement this in the real world. This is where RealWorld comes in! RealWorld is a scenario based learning program. It allows a teacher to create a scenario for the student to facilitate critical thinking.

### Demo

[Watch a video of the application in action!](#)

### Screenshots

<!--
The "App Details" section intends to explain how your app works. Describe the major components, what APIs were used, and what is missing to make this production ready.
-->

## App Details

RealWorld allows a teacher to login to RealWorld desktop application and create, edit, disable, enable, and delete assignments. Once an assignment is created and enabled, a student can log in to complete the assignment. Every question in the assignment stores its own scenario, which allows a teacher to adjust every scenario for every question if needed. RealWorld is a barebones application that can be used for any number of subjects and assignments, the possibilities are endless!

### API Usage

 * [LearningStudio API](http://developer.pearson.com/learningstudio/course-apis/course-info/enrollment/reference) - provides classes, rosters, and roles
 * [Pearson Dictionaries API](http://developer.pearson.com/apis/dictionaries) - provides definitions and translations
 * [Pearson FT Education API](http://developer.pearson.com/apis/ft-education-api) - provides content for teachers to pull from
 * [Firebase JSON Database](https://www.firebase.com/) - provides data storage for classes

### Scope of Functionality 

This program is mostly functional. Missing automatic grades upload due to time constraint on project. It is built to intergrate with any Pearson LearningStudio Campus, all that is needed is a username and password.

<!--
The "Prerequisites" section intends to assist someone get started with your source code. They might not be familar with your frameworks or project structure. Help them out by explaining what you already know. 
-->

## Prerequisites

All libraries used in the project of located in repository with source code under /lib folder

### Build Environment 

 * Netbeans 8.0.2
 * JDK 1.8
 * SwingX 1.6.4 (Included in Project)

<!--
The "Installation" section intends to assist someone deploy your project themselves. What do they need to configure, package, and distribute?
-->

### Application Configuration

/RealWorld/nbproject/project.properties

#### Deploy 

Run /RealWorld/dist/RealWorld.jar

<!--
The "Credit" section intends to highlight your team. Tell who contributed to what parts of the project. Give thanks to mentors that were helpful.
-->

## Credit

Developer - [Nathan Smith](https://github.com/naterman)

Graphic Design - [Kyle Rossi](https://www.facebook.com/Kyle-Rossi-Designs-139509922916790)
![Kyle Rossi Design](https://github.com/naterman/RealWorld_Pearson_Coding/blob/master/resources/kylerossidesigns.png)


### Other

This project would not have been possible without [Professor Kumar](http://trojan.troy.edu/artsandsciences/computerscience/faculty.html). Who informed me of the project and encouraged me through it.

<!--
The "License" section intends to be a license declaration. Checkout choosealicence.com to become familar with different licences. The full license should be included in the LICENSE file, but you can also declare and link to it here.
-->

## License

See License.md
