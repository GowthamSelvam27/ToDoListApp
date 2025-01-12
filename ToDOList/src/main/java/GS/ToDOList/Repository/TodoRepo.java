package GS.ToDOList.Repository;

import GS.ToDOList.Model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoList,Long> {
}
