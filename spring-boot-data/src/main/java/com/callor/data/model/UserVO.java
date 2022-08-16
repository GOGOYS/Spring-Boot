package com.callor.data.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
//VO 클래스를 JPA의 Data Table화 하기 위한 선언
@Entity //지금부터 이 클래스는 Entity 설계를 하기위한 도구이다
//bootDB 라는 Database에 tbl_users라는 이름으로 UserVO를 참조하여 table을 생성
@Table(name="tbl_users",schema = "bootDB")
public class UserVO {

    //seq에 BIGINT PRIMARY KEY AUTO_INCREMENT 설정
    @Id //seq 칼럼이 PK 라는 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // mysql auto_increment 설정을 하여 seq 값을 관리하라
    private long seq;
    //username VARCHAR(20) NOT NULL UNIQUE 설정
    @Column(columnDefinition = "VARCHAR(20)", nullable = false,unique = true)
    private String username;
    // DB 종류에 관계없이 문자열 255자로 설정하라
    // NOT NULL로 설정
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 125)
    private String email;
    @Column(length = 20)
    private String phone;
    //Column을 지정하지 않으면
    //String 형의 경우 문자열 VARCHAR(255)를 default로 설정
    private String address;

    @Column(length = 20)
    private String realname;

    @Column(length = 20)
    private String nickname;
}
