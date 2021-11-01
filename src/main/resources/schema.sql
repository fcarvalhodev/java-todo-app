CREATE TABLE IF NOT EXISTS TODO_LIST(
    todo_list_id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS TODO_ITEM(
     todo_item_id INT PRIMARY KEY,
     item VARCHAR(50),
     complete BIT,
     todo_list_id INT
);