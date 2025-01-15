package GS.ToDOList.Controller;

import GS.ToDOList.Model.TodoList;
import GS.ToDOList.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<TodoList> createTodo(@RequestBody TodoList todoDetails) {
        System.out.println("Received Todo: " + todoDetails.getTitle() + ", " + todoDetails.getDescription());
        TodoList createdTodo = todoService.saveTodo(todoDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }


    @DeleteMapping("/{id}")
    public void deletebyid(@PathVariable Long id){
            todoService.deletebyid(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoList> updateTodo(@PathVariable Long id, @RequestBody TodoList todoDetails) {

        TodoList updateTodo=todoService.updatetodobyid(id,todoDetails);
        return ResponseEntity.ok(updateTodo);


    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoList> patchTodo(@PathVariable Long id, @RequestBody Map<String, Object> updates) {

        TodoList updateTodo=todoService.patchTodoById(id,updates);
        return ResponseEntity.ok(updateTodo);


    }

}
