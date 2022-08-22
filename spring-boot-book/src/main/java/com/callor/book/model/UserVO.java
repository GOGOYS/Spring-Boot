package com.callor.book.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_users")
public class UserVO implements UserDetails {

    @Id
    private String username;

    private String password;
    private boolean enabled;

    private boolean accountNotExpired;
    private boolean accountNonLocked;
    private boolean credentialNonExpired;

    private String email;
    private String realname;

    /*
     @Transient : 이 칼럼은 테이블을 생성할때 만들지 말아라
     */
    @Transient
    Collection<? extends GrantedAuthority> authorities;

    /*  @OneToMany
        tbl_authorities table과 1 : N의 관계를 선언하기
        이 선언을 하게 되면 자동으로 tbl_users table을 SELECT 할때
        tbl_authorities table도 같이 SELECT 하여 하나의 묶음으로 만든다

        UserVO(tbl_users)와 UserRole(tbl_authorities) table간에
        FK 설정이 자동으로 형성된다.

        CascadeType.REMOVE : tbl_users 테이블에서 데이터를 DELETE하면
        tbl_authorities 테이블에 연관데 데이터 자동 삭제하라

        fetch = FetchType.LAZY :
        tbl_users table을 SELECT 한 후 시간을 지연시킨후
        tbl_suthorities table을 SELECT 하라

        List<UserRoles> type 으로 지정해도 되는데
        Set<USerRoles> type으로 지정한 이유
        Listdhk Set은 성질이 많이 비슷하다
        하지만 Set은 List에 비해서 검색속도가 매우 빠르다
        Set은 중복된 데이터를 허용하지 않는다
        만약 중복된 데이터를 add 하면 원래 있던 데이트를 update한다
        Set<Sring> strSet = new HashSet<String>
        strSet.add("홍길동")
        strSet.add("이몽룡")
        strSet.add("홍길동")
        실제 strSet에는 2개의 데이터만 존재 한다.
        Set을 생성할때 HashSet을 사용하면 데이터가 add한 순서대로 저장되지 않는다
        add 한 데이터의 순서를 보장하려면
        Set<String> strSet = new LinkedHashSet<String>()을 사용하여 객체를 초기화 해준다
     */
    @OneToMany(mappedBy = "userVO",cascade = CascadeType.REMOVE ,fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
