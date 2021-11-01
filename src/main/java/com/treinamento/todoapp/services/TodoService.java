package com.treinamento.todoapp.services;

import com.treinamento.todoapp.model.TodoList;
import com.treinamento.todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoList> getTodoList() {
        List<TodoList> todoItems = StreamSupport.stream(todoRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return StreamSupport.stream(todoRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
