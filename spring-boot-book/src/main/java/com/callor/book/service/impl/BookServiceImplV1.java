package com.callor.book.service.impl;

import com.callor.book.model.BookVO;
import com.callor.book.persistance.BookDao;
import com.callor.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImplV1 implements BookService {


    private final BookDao bookDao;

    // alt + insert
    public BookServiceImplV1(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookVO> selectAll() {
        //조건에 관계없이 데이터를 모두 select하기
        List<BookVO> bookList = bookDao.findAll();
        return bookList;
    }

    @Override
    public BookVO findById(String isbn) {
        /*
            일반적인 한개의 데이터를 Select하는 코드
            BookVO bookVO = findById(isbn)
            if(bookVo != null || bookVO.isEmpty(){
                log.debug(bookVo.toString())
            }
         */

        /*
             JPA의 findById()는 return type이 Optional<T>이다.
             Optiondal type은 데이터가 null 인 경우를 좀더 쉽게 처리할 수 있도록 도와주는 도구이다.
         */
        Optional<BookVO> opBookVO = bookDao.findById(isbn);
        /*
            Optional 데이터에서 실제 필요한 데이터를 BookVO를 추출하기 위하여
            get() method, OrElse() method를 사용하여
            만약 포함된 데이터가 null일 경우 다른 bookVO를 생성하여
            데이터가 절대 null이 아니도록 처리할 수 있다.
         */
        BookVO bookVO = opBookVO.orElse(new BookVO());

        return bookVO;
    }

    @Override
    public int insert(BookVO bookVO) {

        /*
            mybatis에서는 insert를 수행한 후 int 값을 return 한다
            이때 return 하는 값은 몇개의 데이터가 추가되었는지를 알려주는 지표이다.

            하지만 JPA에서는 save를 실행한 후 다시 자기 자신(save를 실행한 데이터)를 return
            
            spring-data 에서는 CRUD에서 INSERT와 UPDATE를 별도로 구분하지 않는다
            save() method에 VO를 전달하면
            1.먼저 PK를 기준으로 데이터를 SELECT하여
                테이블에 데이터가 있는지 검사한다
            2.만약 테이블에 PK에 해당하는 데이터가 없으면
                INSERT를 수행한다
            3.또, 테이블에 PK에 해당하는 데이터가 있으면
                UPDATE를 수행한다
         */
        log.debug("서비스 insert:{}",bookVO);
        BookVO result = bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        return 0;
    }

    @Override
    public int delete(BookVO bookVO) {
        return 0;
    }

    @Override
    public List<BookVO> findByTitle(String title) {
        return null;
    }

    @Override
    public List<BookVO> findByComp(String comp) {
        return null;
    }

    @Override
    public List<BookVO> findByAuthor(String author) {
        return null;
    }
}
