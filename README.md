# PicoPlacaCodingExercise
This is a console application designed to verify whether a car is eligible to be driven based on the Pico y Placa rules. 

How does it work?
Once started, the user is given 2 options: CHECK or EXIT. 

1. CHECK
        The user will be prompted to enter a license plate. 
        Then, they will enter a date (in dd/MM/yyyy format) and time (in hh:mm format).
        The app will check if the car is able to be driven on the entered date.
        A message will then be shown, letting the user know if they CAN or CANNOT drive on that day. 
        They will then be sent back to the menu, where they will be able to check as many license plates as they desire. 
3. EXIT
        Once they are done using the app, they can chose to EXIT. 
        This send a "thank you" message and closes the application. 

Project Structure
This project has 4 main classes: 

1. Main: Handles the menu loop.
2. PicoPlacaMethods: Handles user input and output.
3. DateValidator: Contains the logic for the rules of Pico y Placa.
4. LicensePlate: Contains the model and methods related to a license plate. 

Testing
JUnit is used for the automated tests to ensure logic accuracy (valid/invalid plates and pico y placa restrictions). 
To run the test you can open [src/test/java/org/example/PicoPlacaTest.java] and run manually or use Maven to run it automatically (you will need to install it if you don't have it).

Running the app
Run [src/main/java/org/example/Main.java] with an IDE like IntelliJ or VS Code or use Maven. 

