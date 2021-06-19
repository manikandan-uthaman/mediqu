mvn spring-boot:build-image -DskipTests=true -f appointment-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f doctor-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f general-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f notification-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f patient-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f review-service/pom.xml
mvn spring-boot:build-image -DskipTests=true -f staff-service/pom.xml
