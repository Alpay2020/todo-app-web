package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.ToDo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoMongoDb extends PagingAndSortingRepository<ToDo, String> {
    List<ToDo> remove(String id);
}

