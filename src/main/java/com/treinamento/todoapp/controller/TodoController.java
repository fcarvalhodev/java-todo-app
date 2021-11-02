package com.treinamento.todoapp.controller;

import com.treinamento.todoapp.dto.TodoItemDto;
import com.treinamento.todoapp.dto.TodoListDto;
import com.treinamento.todoapp.model.TodoItem;
import com.treinamento.todoapp.model.TodoList;
import com.treinamento.todoapp.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/lists")
    public List<TodoListDto> getTodoLists() {
        return todoService.getTodoList();
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "/todos")
    public void addTodo(@RequestBody TodoListDto todo){
        todoService.addTodo(todo);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/todos/{id}")
    public TodoList addTodoItem(@RequestBody TodoItemDto item, @PathVariable  Long id){
        return todoService.addTodoItem(item, id);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = "/todos/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

}
