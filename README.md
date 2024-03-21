# JAVA SPRING BOOT PROJECT

Project Name: Healthcare_System

Tools/Technologies Used: Advanced Java, Spring Boot Framework, Hibernate, MySQL, Postman, Eclipse.

<br>

Task Description:-

We have a platform where doctors can register their patients through a mobile or web portal. For this to work we need to build backend APIs to achieve task like:

Adding a doctor & their speciality
Adding a patient & it’s symptom
Suggesting the doctor based on patient’s symptom

#Doctor’s entity

In our database we will have the doctor's name, city, email, phone number, and speciality.

City can have 3 values only i.e. Delhi, Noida, Faridabad
Speciality can have 4 values i.e. Orthopedic, Gynecology, Dermatology, ENT specialist
A doctor can be added or removed from the platform.


#Patient’s entity

In our database we will have the patient's name, city, email, phone number, and symptom.

City can have any value
Symptom can have the following values only
Arthritis, Back Pain, Tissue injuries (comes under Orthopedic speciality)
Dysmenorrhea (comes under Gynecology speciality)
Skin infection, skin burn (comes under Dermatology speciality)
Ear pain (comes under ENT speciality)
A patient can be added or removed from the platform.


Following fields should have the mentioned validations at the backend:

Name (should be at least 3 characters)
City (should be at max 20 characters)
Email (should be a valid email address)
Phone number (should be at least 10 number)

#Suggesting Doctors

There will be another API that will accept patient ID, and suggest the doctors based on the patient location and the symptom.

E.g. 1: If the patient ID that we received as request param in this API, that patient has Arthritis as a symptom then all the doctors of that location who is an Orthopedic will be sent as the response, since Arthritis comes under Orthopedic speciality.


Important Note: This suggesting doctor API  is the evaluating API where the logic needs to be working. The suggested doctor in the API should be based on the symptom of the patient that links to the doctor's speciality. E.g. 2: If a patient has Eye pain then only an ENT specialist doctor should be suggested.

Edge-Case 1: If there isn’t any doctor on that location (i.e. outside Delhi, Noida, Faridabad), the response should be “We are still waiting to expand to your location”

Edge-Case 2: If there isn’t any doctor for that symptom on that location, the response should be “There isn’t any doctor present at your location for your symptom”

<br>

How to run:-

To Start the application -> Run it as spring boot project in eclipse -> Look for "Controller" package -> Go through both Doctor and Patient controller classes -> use endpoints from these classes (Do check your Tomcat PORT)

Check the "application.properties" file, do configure the database connection like PORT, username, password, etc.
