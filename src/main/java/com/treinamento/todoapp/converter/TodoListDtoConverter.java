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
public class TodoListDtoConverter implements Converter<TodoListDto, TodoList> {

    private final TodoItemDtoConverter itemDtoConverter;

    public TodoListDtoConverter(TodoItemDtoConverter itemDtoConverter) {
        this.itemDtoConverter = itemDtoConverter;
    }

    @Override
    public TodoList convert(TodoListDto todoListDto) {
        List<TodoItemDto> items = todoListDto.getItems();

        List<TodoItem> itemDtos = items.stream()
                .map(itemDtoConverter::convert)
                .collect(Collectors.toList());

        return new TodoList(todoListDto.getName(), itemDtos);
    }
}
