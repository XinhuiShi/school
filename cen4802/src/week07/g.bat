setlocal
:: Set foryour local installation
SET GRADLE_HOME="C:\Users\Scott LaChance\Documents\school\tools\gradle\gradle-5.2.1-bin\gradle-5.2.1\"

:: Don't change
SET PATH=%GRADLE_HOME%bin;%PATH%
SET GRADLE_EXE=gradle.bat

:: g <task>
%GRADLE_EXE% %1

endlocal