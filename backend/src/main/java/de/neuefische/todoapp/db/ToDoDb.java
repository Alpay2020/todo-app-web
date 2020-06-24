package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.model.ToDoStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDb {

    private final List<ToDo> todolist = new ArrayList<>();

    /*private final List<ToDo> todostatusopen = new ArrayList<>();
    private final List<ToDo> todostatusinprogress = new ArrayList<>();
    private final List<ToDo> todostatusdone = new ArrayList<>();

    public void add(ToDo newtodo) {
        this.todostatusopen.add(newtodo);
    }
    public List<ToDo> getToDoListStatusOpen() {
        return todostatusopen;
    }
    public List<ToDo> getToDoListStatusInProgress() {
        return todostatusinprogress;
    }
    public List<ToDo> getToDoListStatusDone() {
        return todostatusdone;
    }*/
    public void add(ToDo newtodo) {
        this.todolist.add(newtodo);
    }
    public List<ToDo> getToDoList() {
        return todolist;
    }
    public ToDo updateToDoStatus(String id, ToDo status) {
        for (ToDo aDo : todolist){
            if (aDo.getId().equals(id)) {
                aDo.setStatus(status.getStatus());
                return aDo;
            }
        }
        return null;
    }
    public List<ToDo> removeToDo(String id) {
        for (ToDo toDo : todolist) {
            if (toDo.getId().equals(id)) {
                todolist.remove(toDo);
                return todolist;
            }
        }
        return null;
    }
}