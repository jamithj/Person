set SCRIPT_DIR=%~dp0
java -Dsbt.ivy.home=%IVY_HOME%\.ivy2\ -Dsbt.boot.realm="Artifactory Realm" -Dsbt.boot.host="artifactory-remote.its.monash.edu" -Dsbt.boot.user=sbt -Dsbt.boot.password=password -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -Xmx1024M -Xss2M -jar "%SCRIPT_DIR%\sbt-launch-0.13.5.jar" %*
