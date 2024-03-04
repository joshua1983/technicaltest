plugins {
   java
   id("org.springframework.boot") version "2.7.0"
   id("io.spring.dependency-management") version "1.1.4"
}

group = "com.inclusion"
version = "0.0.1-SNAPSHOT"

java {
   sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
   mavenCentral()
}

dependencies {
   implementation("org.springframework.boot:spring-boot-starter-web")
   implementation("org.projectlombok:lombok")
   annotationProcessor("org.projectlombok:lombok")
   testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
   useJUnitPlatform()
}
