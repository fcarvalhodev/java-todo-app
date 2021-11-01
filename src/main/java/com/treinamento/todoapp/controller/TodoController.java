package com.treinamento.todoapp.controller;

import com.treinamento.todoapp.model.TodoList;
import com.treinamento.todoapp.services.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/lists")
    public List<TodoList> getTodoLists() {
        return todoService.getTodoList();
    }
}
