package com.callor.todo.service.impl;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoDao todoDao;
    public TodoServiceImpl(TodoDao todoDao){
        this.todoDao = todoDao;
    }

    @Override
    public List<TodoVO> selectAll() {
        return todoDao.findAll();
    }

    @Override
    public TodoVO fineById(Long seq) {

        Optional<TodoVO> opVO = todoDao.findById(seq);
        TodoVO todoVO = opVO.orElse(new TodoVO());
        return todoVO;
    }

    @Override
    public int insert(TodoVO todoVO) {
        TodoVO result = todoDao.save(todoVO);
        return 0;
    }

    @Override
    public int update(TodoVO todoVO) {
        return 0;
    }

    @Override
    public int delete(Long seq) {
        return 0;
    }
}
