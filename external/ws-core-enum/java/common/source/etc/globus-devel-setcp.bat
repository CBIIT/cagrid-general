@echo off
set _CLASSPATHCOMPONENT=%1
:argCheck
if %2a==a goto gotAllArgs
shift
set _CLASSPATHCOMPONENT=%_CLASSPATHCOMPONENT% %1
goto argCheck
:gotAllArgs
set CLASSPATH=%_CLASSPATHCOMPONENT%;%CLASSPATH%
