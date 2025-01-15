package GS.ToDOList.TodoService;

import GS.ToDOList.Model.TodoList;
import GS.ToDOList.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    public List<TodoList> getall() {
        return todoRepo.findAll();
    }

    public TodoList saveTodo(@RequestBody TodoList req) {
        if (req.getTitle() == null || req.getDescription() == null) {
            throw new IllegalArgumentException("Title and Description cannot be null");
        }
        return todoRepo.save(req);
    }


    public void deletebyid(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }

    public TodoList updatetodobyid(Long id, TodoList todoDetails) {
        TodoList todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setStatus(todoDetails.isStatus());

        return todoRepo.save(todo);
    }

    public TodoList patchTodoById(Long id, Map<String, Object> updates) {

        TodoList todo = todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        if (updates.containsKey("title")) {
            todo.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("description")) {
            todo.setDescription((String) updates.get("description"));
        }
        if (updates.containsKey("completed")) {
            todo.setStatus((Boolean) updates.get("completed"));
        }

        return todoRepo.save(todo);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
