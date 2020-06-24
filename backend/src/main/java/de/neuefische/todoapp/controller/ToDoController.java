package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static de.neuefische.todoapp.model.ToDoStatus.IN_PROGRESS;

@RestController
@RequestMapping("api/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
    @PutMapping
    public ToDo addToDo(@RequestBody ToDo newtodo){
        return toDoService.addToDo(newtodo);
    }
    @PutMapping("{id}/status")
    public ToDo updateToDoStatus(@PathVariable String id, @RequestBody ToDo status){
        return toDoService.updateToDoStatus(id,status);
    }
    @DeleteMapping("{id}")
    public List<ToDo> removeToDo(@PathVariable String id){
        return toDoService.removeToDo(id);
    }
    /*@GetMapping("open")
    public List<ToDo> getToDoListStatusOpen(){
        return toDoService.getToDoListStatusOpen();
    }
    @GetMapping("inprogress")
    public List<ToDo> getToDoListStatusInProgress(){
        return toDoService.getToDoListStatusInProgress();
    }
    @GetMapping("done")
    public List<ToDo> getToDoListStatusDone(){
        return toDoService.getToDoListStatusDone();
    }*/
    @GetMapping
    public List<ToDo> getToDoList() {
        return toDoService.getToDoList();
    }

}
