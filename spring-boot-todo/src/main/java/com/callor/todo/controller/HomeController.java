package com.callor.todo.controller;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value={"","/"}, method= RequestMethod.GET)
    public String home(Model model){

        List<TodoVO> todoList = todoService.selectAll();

        model.addAttribute("TODO",todoList);

        return "home";
    }

    @RequestMapping(value={"","/"}, method= RequestMethod.POST)
    public String home(TodoVO todoVO, Model model){

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("Hh:mm:ss");

        todoVO.setS_date(dateFormat.format(date));
        todoVO.setS_time(timeFormat.format(date));

        todoService.insert(todoVO);

        return "redirect:/";
    }
}
