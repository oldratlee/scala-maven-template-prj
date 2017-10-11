scala-maven-template-prj
================================

:point_right: Scala maven project skeleton and simple show case of common scala ecosystem libs.

## Scala maven project skeleton

1. joint-compile configuration for scala and java
1. logging lib configuration: scala use scala-logging, java use slf4j
1. test libs configuration: scalatest/Spec2/scalacheck/JUnit
1. mock libs configuration: mockito/scalamock

## Simple show case

1. poso(Plain Old Scala Object)/pojo class (use **between** languages) 
    - poso: [Employee](core/src/main/scala/com/oldratlee/scala/hello/Models.scala)
    - pojo: [Company](core/src/main/java/com/oldratlee/scala/hello/Company.java)
1. scala/java hello world main class (invoke **between** languages)
    - scala: [ScalaMain](core/src/main/scala/hello/ScalaMain.scala)
    - java: [JavaMain](core/src/main/java/hello/JavaMain.java)
1. Logging
    - scala: [ScalaLogDemo](core/src/test/scala/showcase/log/ScalaLogDemo.scala)
    - java: [JavaLogDemo](core/src/test/java/showcase/log/JavaLogDemo.java)
1. Spec2/scalatest/scalacheck/JUnit test by scala/java
    - scala:
        - Spec2: [Spec2_HelloWorld_Test](core/src/test/scala/showcase/testing/specs2/Spec2_HelloWorld_Test.scala)
        - scalatest: **_TODO_**
        - scalacheck: [BasicScalaCheckPropertiesTest](core/src/test/scala/showcase/testing/scalacheck/BasicScalaCheckPropertiesTest.scala)  
            This is a scalacheck standalone test, so `mvn test` can not recognize it, but `IDEA` can.  
            More practical usage should integrate scalacheck with `scalatest` or `Spec2`, so can be recognized by `maven test`. **_TODO_**
        - JUnit: [Hello_Junit4ByScala_Test](core/src/test/scala/showcase/testing/junit/Hello_Junit4ByScala_Test.scala)
    - java:
        - JUnit
            - [Hello_Junit4ByJava_Test](core/src/test/java/showcase/testing/junit/Hello_Junit4ByJava_Test.java)
            - [Hello_Junit3ByJava_Test](core/src/test/java/showcase/testing/junit/Hello_Junit3ByJava_Test.java)
