package kz.com.reservation.reservation.task.service;

import kz.com.reservation.reservation.task.entity.Task;
import kz.com.reservation.reservation.task.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;
    private final static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        logger.info("Fetching all task");
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        logger.info("Get task by id from database {}",id);
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        logger.info("Create new task {}",task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {
        logger.info("Update task {}",task);
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logger.info("Delete task by id {} ",id);
        taskService.deleteTaskById(id);
        return ResponseEntity.ok()
                .build();
    }
}
