INSERT INTO TODO_LIST (todo_list_id,name) VALUES (1, 'Languages to learn');
INSERT INTO TODO_LIST (todo_list_id,name) VALUES (2, 'Languages to continue learning');
INSERT INTO TODO_LIST (todo_list_id,name) VALUES (3, 'Languages to master');

INSERT INTO TODO_ITEM (todo_item_id, item, complete, todo_list_id) VALUES (1, 'Kotlin', FALSE, 1);
INSERT INTO TODO_ITEM (todo_item_id, item, complete, todo_list_id) VALUES (2, 'Swift', FALSE, 1);

INSERT INTO TODO_ITEM (todo_item_id, item, complete, todo_list_id) VALUES (3, 'Golang', TRUE, 2);

INSERT INTO TODO_ITEM (todo_item_id, item, complete, todo_list_id) VALUES (4, 'Java', FALSE, 3);
INSERT INTO TODO_ITEM (todo_item_id, item, complete, todo_list_id) VALUES (5, 'Python', FALSE, 3);