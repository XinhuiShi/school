setlocal
:: Set for your local installation
SET GRADLE_HOME="C:\Users\Scott LaChance\Documents\school\tools\gradle\gradle-5.2.1-bin\gradle-5.2.1\"
SET JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131

:: Don't change
SET PATH=%GRADLE_HOME%bin;%PATH%
SET GRADLE_EXE=gradle.bat

:: g <task>
%GRADLE_EXE% init --type java-application

endlocal

