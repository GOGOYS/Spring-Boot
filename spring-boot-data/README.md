# Spring Data Project

* Spring Data Project Dependencies
* starter-data-jdbc는 spring data(JPA)를 호환성 때문에 사용하며
현재 사용하는 spring-boot버전에서는 선택사항이다
```xml
<dependency>
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```