package com.callor.data.psersistance;


/*
 자동 import하기
 빨간색으로 나타나는 클래스, method에 커서를 두고 ALT-Enter
 import 최적화 : Ctrl + ALT + 0(영문자O)
 */
import com.callor.data.model.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Spring-data(JPA)에서는 JpaRepository를 Generic 방식으로 상속받아 사용한다.
 */
public interface UserRepository extends JpaRepository<UserVO, Long> {
    
    // Ctrl + o 를 하면 JpaRepository에서 기본 제공하는 CRUD 사용가능
    
}
