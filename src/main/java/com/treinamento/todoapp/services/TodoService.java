package com.treinamento.todoapp.services;

import com.treinamento.todoapp.converter.TodoItemDtoConverter;
import com.treinamento.todoapp.converter.TodoListConverter;
import com.treinamento.todoapp.converter.TodoListDtoConverter;
import com.treinamento.todoapp.dto.TodoItemDto;
import com.treinamento.todoapp.dto.TodoListDto;
import com.treinamento.todoapp.model.TodoList;
import com.treinamento.todoapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoListConverter todoListConverter;
    private final TodoListDtoConverter todoListDtoConverter;
    private final TodoItemDtoConverter todoItemDtoConverter;

    public TodoService(TodoRepository todoRepository, TodoListConverter todoListConverter, TodoListDtoConverter todoListDtoConverter,TodoItemDtoConverter todoItemDtoConverter) {
        this.todoRepository = todoRepository;
        this.todoListConverter = todoListConverter;
        this.todoListDtoConverter = todoListDtoConverter;
        this.todoItemDtoConverter = todoItemDtoConverter;
    }

    public List<TodoListDto> getTodoList() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(),false).map(todoListConverter::convert).collect(Collectors.toList());
    }

    public void addTodo(TodoListDto todo) {
        todoRepository.save(Objects.requireNonNull(todoListDtoConverter.convert(todo)));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoList addTodoItem(TodoItemDto item, Long id){
        Optional<TodoList> todoList = todoRepository.findById(id);
        if (todoList.isEmpty()) {
            return null;
        }else{
            TodoList concretList = todoList.get();
            concretList.addTodoItem(todoItemDtoConverter.convert(item));
            todoRepository.save(concretList);
            return concretList;
        }
    }
}
