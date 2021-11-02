package com.treinamento.todoapp.converter;

import com.treinamento.todoapp.dto.TodoItemDto;
import com.treinamento.todoapp.dto.TodoListDto;
import com.treinamento.todoapp.model.TodoItem;
import com.treinamento.todoapp.model.TodoList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoListConverter implements Converter<TodoList, TodoListDto> {

    private final TodoItemConverter itemConverter;

    public TodoListConverter(TodoItemConverter itemConverter) {
        this.itemConverter = itemConverter;
    }

    @Override
    public TodoListDto convert(TodoList todoList) {
        List<TodoItem> items = todoList.getItems();

        List<TodoItemDto> itemDtos = items.stream()
                .map(itemConverter::convert)
                .collect(Collectors.toList());

        return new TodoListDto(todoList.getName(), itemDtos);
    }

}
