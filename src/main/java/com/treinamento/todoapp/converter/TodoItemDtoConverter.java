package com.treinamento.todoapp.converter;

import com.treinamento.todoapp.dto.TodoItemDto;
import com.treinamento.todoapp.model.TodoItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDtoConverter implements Converter<TodoItemDto, TodoItem> {

    @Override
    public TodoItem convert(TodoItemDto item) {
        return new TodoItem(item.getItem(), item.isComplete());
    }
}
