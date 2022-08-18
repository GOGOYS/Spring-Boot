package com.callor.book.contorller;

import com.callor.book.model.BookVO;
import com.callor.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value={"/",""},method= RequestMethod.GET)
    public String home(Model model){

        List<BookVO> bookList = bookService.selectAll();
        model.addAttribute("BOOKLIST",bookList);
        return "home";
    }

    @RequestMapping(value="",method=RequestMethod.POST)
    public String home(BookVO bookVO){

        bookService.insert(bookVO);

        log.debug("받은데이터:{}",bookVO);
        return "redirect:/";
    }
}
