@ECHO OFF

REM Move one directory level up
cd ..

REM create bin directory if it doesn't exist
if not exist .\bin mkdir .\bin

REM delete output from previous run
if exist .\text-ui-test\ACTUAL.TXT del .\text-ui-test\ACTUAL.TXT

REM compile the code into the bin folder
javac  -cp .\src\main\java -Xlint:none -d .\bin .\src\main\java\hal9000\*.java .\src\main\java\hal9000\task\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath .\bin hal9000.Hal9000 < .\text-ui-test\input.txt > .\text-ui-test\ACTUAL.TXT

REM compare the output to the expected output
FC .\text-ui-test\ACTUAL.TXT .\text-ui-test\EXPECTED.TXT
