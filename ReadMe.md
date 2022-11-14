#Context
G-Man is a video game in which G-Man has to move from one point to another on a grid (6 X 6 grid). There could be multiple paths between a source coordinate and destination coordinate and G-Man needs to reach the destination by spending least amount of power.

Position
 G-Man’s position is located by the x, y coordinate of the grid. 
 One of the four compass points N, E, S and W indicates the direction G-Man is facing. 
 Eg: 2, 1 N means the G-Man is at 2 on the x coordinate, 1 on the y coordinate, and facing North.
 
6 X 6 Grid

Moves
 At the start of the game, G-Man is given a power of 200 units. His power is reduced for every move and turn he takes.
 
G-Man can turn left or right 90 degrees at a time to change his direction.
For every turn G-Man makes, his power is reduced by 5.
For every move that G-Man makes by 1 grid point, his power is reduced by 10.
  eg: If G-Man moves from 2, 1 E to the destination 4, 1 he loses 20 power points. 
  eg: If G-Man moves from 2, 1 S to 4, 5; he has to turn twice and move 6 grid points. So he loses 70 power points. ![gman-grid](https://user-images.githubusercontent.com/59720572/201669790-e869ec7d-1813-4add-b654-874cbedb7367.png)

Goal
 Given the source and destination coordinates, G-Man needs to reach the destination by spending least amount of power. And you need to print the remaining power he has after taking the shortest path with minimum number of turns.

#Score

![detailedscore](https://user-images.githubusercontent.com/59720572/201671258-0c38e9e6-22ef-428e-913b-d97cb940906e.png)

# Pre-requisites
* Java 1.8/1.11/1.15
* Maven

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems and `run.bat` if you are on Windows.  Both the files run the commands silently and prints only output from the input file `sample_input/input1.txt`. You are supposed to add the input commands in the file from the appropriate problem statement. 

Internally both the scripts run the following commands 

 * `mvn clean install -DskipTests assembly:single -q` - This will create a jar file `geektrust.jar` in the `target` folder.
 * `java -jar target/geektrust.jar sample_input/input1.txt` - This will execute the jar file passing in the sample input file as the command line argument

 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

 Use the pom.xml provided along with this project. Please change the main class entry (`<mainClass>com.example.geektrust.Main</mainClass>`) in the pom.xml if your main class has changed.

 # Running the code for multiple test cases

 Please fill `input1.txt` and `input2.txt` with the input commands and use those files in `run.bat` or `run.sh`. Replace `java -jar target/geektrust.jar sample_input/input1.txt` with `java -jar target/geektrust.jar sample_input/input2.txt` to run the test case from the second file. 

 # How to execute the unit tests

 `mvn clean test` will execute the unit test cases.

# Help

You can refer our help documents [here](https://help.geektrust.com)
You can read build instructions [here](https://github.com/geektrust/coding-problem-artefacts/tree/master/Java)
