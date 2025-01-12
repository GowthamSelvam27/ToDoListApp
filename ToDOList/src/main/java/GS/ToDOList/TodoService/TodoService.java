package GS.ToDOList.TodoService;

import GS.ToDOList.Model.TodoList;
import GS.ToDOList.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;


    public List<TodoList> getall() {
        return todoRepo.findAll();
    }

    public TodoList saveTodo(@RequestBody TodoList req) {
        return todoRepo.save(req);
    }

    public void deletebyid(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }
}
