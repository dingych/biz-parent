echo on
setlocal enabledelayedexpansion

if "%1"=="" goto BLANK
if "%2"=="" goto BLANK

set projectName=%1
set packageName=%2
set archetypeVersion=LATEST

echo Y | mvn archetype:generate ^
    -DarchetypeCatalog=local ^
    -DarchetypeGroupId=cn.waynechu ^
    -DarchetypeArtifactId=biz-spring-cloud-archetype ^
    -DarchetypeVersion=%archetypeVersion% ^
    -DgroupId=com.waynechu ^
    -DartifactId=%projectName% ^
    -Dversion=0.0.1-SNAPSHOT ^
    -Dpackage=com.waynechu.%packageName% ^
    & ren %projectName% biz-spring-cloud-api-%projectName%