javac ClassPath.java
md mysubclass
copy AAA.class .\mysubclass\AAA.class
copy BBB.class .\mysubclass\BBB.class
del AAA.class
del BBB.class
set classpath=.;.\mysubclass
java ClassPath
pause
