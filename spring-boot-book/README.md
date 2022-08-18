# Spring Boot Data Project
## 도서정보 관리 프로젝트

## Spring Data Project
* spring-data project는 DBMS와 연동하여 CRUD를 구현하는 Project
* spring-JPA(Java Persistance API, Archutecture) : ORM(Object Relation Mappring)
* 일반적으로 DBMS와 연동하기 위해서는 SQL 문법, 명령구조 등을 필수로 익혀야 한다
* Java 개발자들 중에는 SQL 문법에 대해 어려움을 겪는 경우가 많다. 그래서 SQL을 사용하지 않고,
Java의 객체(class)만을 디자인하여 DBMS와 관련되 CRUD를 구현하는 것을 목표로 탄생된 도구


## srping boot 구조
* ServletInitializer와 BookApplication파일이 자동생성된다.
* BookApplication의 main 함수를 실행하여 서버 구동시 실행
* Run 할때 문제가 있는 경우 BookApplication 파일을 열어 Run을 실행시켜줘야한다


## Spring-data-JPA 시작할때 설정
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
<!-- MySQL 연동 JDBC 설정 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
```
* spring-data-jpa 프로젝트는 반드시 초기에 DB 설정이 있어야한다.
* DB 설정이 없을경우 프로젝트 시작 자체가 되지 않는다.

## 파일 이름 변경 => 쉬프트+ F6

## spring-data 설정
* resources -> application.properties에서 DB setting