## Java Weather APP 
CS222 Final Project Group B
Weather App

## Authors
Nicholas Newlin
Campbell Reed
Will Pancake
Devlin Hicks

## Summary
This Java project demonstrates the ability to connect to Weather API's servers to fetch the current weather data like
the temperature and weather conditions. The program prompts for a zip code, and will display the temperature in either
Celsius or Fahrenheit, and the current conditions. 

## Build Requirements
We used several external libraries as shown in the build.gradle file. Java 20 and gradle is required for this project. 

## Directions to setup and run the program
1) Go to WeatherAPI.com and create an account to get an API key so that you can run the program.
2) Remember the API key for later.
3) Pull the project from github using an intleij by using the get from VCS option.
4) Once the project has been pulled you need to create a resource Directory under the Java directory by right clicking and choosing the option to create a resource Directory.
5) Now you need to create a file called api_key.txt
6) After you create the file you need to paste the API key from earlier into the file with no spacing before the text.
7) Next you can run the program by selecting the WeatherApp class and then you will click the play button next to the code to run it.
8) After you select the play button you will need to input the information for the questions asked. (If the API key is not found it will tell you the key was not found)

## Functional Requirements
1) As a landscaper, I want to know what the current temperature is in my location so I can wear a hat and gloves if needed.
    a) Conditions of Satisfaction:
        i) I can enter a valid zip code on the command line
        ii) If the location cannot be found, the program will alert the user and prompt again for a valid location

2) As a landscaper, I want to be able to switch between Celsius and Fahrenheit so that I can know what the temperature is on both unit scales.
    a) Conditions of Satisfaction:
        i) I can enter a valid zip code on the command line
        ii) If the location cannot be found, the program will alert the user and prompt again for a valid location
        iii) The program will prompt me to choose to display the units in Celsius or Fahrenheit.

3) As a landscaper, I need to know what the weather conditions are in my current location so that I can wear a rain jacket if needed.
    a) Conditions of Satisfaction:
        i) I can enter a valid zip code on the command line
        ii) If the location cannot be found, the program will alert the user and prompt again for a valid location
        iii) The program will prompt me to choose to display the units in Celsius or Fahrenheit.
        iv) The program will print the temperature in the selected units
        v) The program will print the current weather conditions

4) As a landscaper, I want to be able to see the temperature, in either Fahrenheit or Celsius, based on zip codes from either the US,  Canada, or the UK displayed within a GUI.
    a) Conditions of Satisfaction:
        i) I will be able to see the temperature of an area based on ZIP Codes, from the aforementioned nations.
        ii) I can choose between either Fahrenheit or Celsius Temperature Systems.
        iii) The output will be within a GUI window. 

5) As a landscaper, I want to be able to see the temperature of my location in Celsius and Fahrenheit displayed within a GUI. 
    a) Conditions of Satisfaction:
        i) After the program has accepted my location I want to have a button to display temperature in Celsius or Fahrenheit.

6) As a landscaper, I want to be able to see the temperature, weather conditions, and the time in my location 
   a) Conditions of Satisfaction:
       i) Below the weather data, the time and date will be shown in the GUI.

7) As a project manager at a landscaping company, I want to be able to see the weather forecast for the next 3 days so that I can plan when     to work on which jobs. 
    a) Conditions of Satisfaction:
        i) Display in a list format, the minimum and maximum temperature for the next three days. 

8) As a foreman at a landscaping company, I want to be able to see the temperature in both celsius and fahrenheit in a Graphical user           interface.
    a) Conditions of Satisfaction:
        i) After the program has accepted my location I want to have a button to display temperature in celsius or Fahrenheit or both at the            same time. 

9) As a foreman at a landscaping company, I need to know the time at a job site because my company oversees jobs in different time zones when I request the current weather conditions for the location. 
    a) Conditions of Satisfaction:
        i) After the program takes my location as input it will display the time in the city that I entered. 
					

## Errors
1) When running the program it will print to the user "Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.
You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.
Which is not a problem yet. This line tells the user that in the future it will not work with gradle 9.0 due to how this program is configured.
## Sources Used
1) Stackoverflow was used for assistance to change java.io.file.getbuilddir to an updated dependency. 
2) Example code and setup info was used from https://logging.apache.org/log4j/2.x/maven-artifacts.html to switch from stacktrace logging to log4j. 
3) Chatgpt was used to generate part of the user interface but was redesigned using scenebuilder. 
4) Stackoverflow was used to help find a solution for printing the current time and date as well as to fix an issue with a test failing due to latency with the comparison of the two values.
