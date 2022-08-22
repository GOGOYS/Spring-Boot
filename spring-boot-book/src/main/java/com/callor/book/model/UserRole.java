package com.callor.book.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name= "tbl_authorities")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    private String username;
    private String rolename;

    /*
        두 테이블을 1:N 관계로 설정할 경우
        Master 클래스에 @OneToMany를 설정하고
        관계 연결되는 클래스에 ManyToOne 설정이 필요하다

        name : UserRole.username 칼럼과
        referencedColumnName : UserVO.username을 서로 연결
        insertable = false, updatable = false 속성을 false로 설정한 이유
        tbl_user나 tbl_authorities 테이블에 insert나 update가 발생할 경우 동시에 실행하지 말라
     */
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserVO userVO;
}
