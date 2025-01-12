package GS.ToDOList.Controller;

import GS.ToDOList.Model.TodoList;
import GS.ToDOList.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoControllers {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoList> get(){
        return todoService.getall();

    }

    @PostMapping
    public TodoList CreateTodo(TodoList req){
        return todoService.saveTodo(req);
    }

    @DeleteMapping("/{id}")
    public void deletebyid(@PathVariable Long id){
            todoService.deletebyid(id);
    }

}
