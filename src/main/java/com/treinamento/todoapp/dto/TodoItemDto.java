package com.treinamento.todoapp.dto;

public class TodoItemDto {

    private String item;
    private boolean complete;

    public TodoItemDto(String item, boolean complete) {
        this.item = item;
        this.complete = complete;
    }

    public String getItem() {
        return item;
    }

    public boolean isComplete() {
        return complete;
    }
}
