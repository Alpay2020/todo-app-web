package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.ToDoDb;
import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static de.neuefische.todoapp.model.ToDoStatus.OPEN;

@Service
public class ToDoService {

    private final ToDoDb toDoDb;

    @Autowired
    public ToDoService(ToDoDb toDoDb) {
        this.toDoDb = toDoDb;
    }
    public ToDo addToDo(ToDo newtodo) {
        String uuid = UUID.randomUUID().toString();
        newtodo.setId(uuid);
        newtodo.setStatus(OPEN);
        toDoDb.add(newtodo);
        return newtodo;
    }
    public List<ToDo> getToDoList() {
        return toDoDb.getToDoList();

    /*public List<ToDo> getToDoListStatusOpen() {
        return toDoDb.getToDoListStatusOpen();
    }

    public List<ToDo> getToDoListStatusInProgress() {
        return toDoDb.getToDoListStatusInProgress();
    }

    public List<ToDo> getToDoListStatusDone() {
        return toDoDb.getToDoListStatusDone();
    }*/
    }
    public ToDo updateToDoStatus(String id, ToDo status){
        return toDoDb.updateToDoStatus(id,status);
    }
    public List<ToDo> removeToDo(String id){
        return toDoDb.removeToDo(id);
    }

}