This is an WEB application project that was built with Spring MVC, Maven, Hibernate, REST and JUnit technologies.  
It provides you the possibility to choose one or many (three) files for parsing (it accept only ".txt" files so be careful). 
Parsing is able to occur in three parallel ways with the help of Spring`s "taskExecutor" and settings of Tomcat, 
that is limited to work only in three threads. Result of parsing is a list of lines that were received in one 
or three files with the number of occurrences of the string in file/files.