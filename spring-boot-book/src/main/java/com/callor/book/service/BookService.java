package com.callor.book.service;

import com.callor.book.model.BookVO;

import java.util.List;
import java.util.Optional;

public interface BookService{

    public List<BookVO> selectAll();

    /*
        spring-data와 관련된 method에서 findById() method의 return type이 Optional<T> 이다.

        보통 findById(id)는 1개의 데이터를 SELECT 하여 VO에 담아주는 method이다.
        그런데 id에 해당하는 데이터가 없을 경우 findById()는 null 값을 return 한다.
        null 값을 return 한다는 것은 잠재적으로 nullPointer Exception을 일으킬 수 있다는 것이다.

        보통 이 return된 데이터를 취급할때 값이 null인가를 검사하는 코드를 번거롭게 만들어야함
        이러한 경우를 감소하고 코드를 줄이기 위하여 null 값이 될만한 데이터는
        Optional로 감싸서 null 검사를 쉽게 할수 있도록 도와주는 type

        실제 데이터를 감싸는 Wrapper이며 null 취급을 쉽게 할 수 있도록 하는 도구
     */
    public BookVO findById(String isbn);
    public int insert(BookVO bookVO);
    public int update(BookVO bookVO);
    public int delete(BookVO bookVO);

    public List<BookVO> findByTitle(String title);
    public List<BookVO> findByComp(String comp);
    public List<BookVO> findByAuthor(String author);

}
