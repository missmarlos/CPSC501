How to Run Code:
javac *.java
java Main

Commands Within the Program:
Login: login
Sign Up: signup
Diary: diary
	Make File: make file
	Display File: display file
	Remove File: remove file
	Edit File: edit file
Todo: todo
	Add Task: add task
	Complete Task: complete task
Agenda: agenda
	Add Entry: add

How to Run Test:
have the junit zip files in the same directory as the classes
copy and paste the following into the terminal:
export CLASSPATH=$CLASSPATH:~/java/junit-4.13-beta-3.jar
export CLASSPATH=$CLASSPATH:~/java/hamcrest-core-1.3.jar
javac *.java
java org.junit.runner.JUnitCore ProgramTest

Notes:
Do not add anything to testTextFile.txt, this file is strictly for testing purposes only.
