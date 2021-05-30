## Compile client
javac -classpath `pwd`:`pwd`/../lib/activation-1.1.1.jar:`pwd`/../lib/jaxb-api-2.3.1.jar:`pwd`/../lib/org.eclipse.persistence.moxy-2.7.3.jar:`pwd`/../lib/jaxb-api-2.2.jar:`pwd`/../lib/jaxb-impl-2.0.1.jar *.java data/*.java scheduler/*.java

## Run client
java -cp `pwd`:`pwd`/../lib/activation-1.1.1.jar:`pwd`/../lib/jaxb-api-2.3.1.jar:`pwd`/../lib/org.eclipse.persistence.moxy-2.7.3.jar:`pwd`/../lib/jaxb-api-2.2.jar:`pwd`/../lib/jaxb-impl-2.0.1.jar -n Client.class
