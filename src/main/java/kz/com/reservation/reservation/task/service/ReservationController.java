package kz.com.reservation.reservation.task.service;

import kz.com.reservation.reservation.task.entity.Task;
import kz.com.reservation.reservation.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final TaskRepository taskRepository;

    @Autowired
    public ReservationController(ReservationService reservationService, TaskRepository taskRepository) {
        this.reservationService = reservationService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public String getTasks() {
        System.out.println("Received all tasks");
        return reservationService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable Long id) {
        System.out.println("Received task with id: " + id);
        return reservationService.getTaskById(id);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        System.out.println("Creating task: " + task);
        return reservationService.createTask(task);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task Task) {
        return reservationService.updateTask(id, Task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        reservationService.deleteTaskById(id);


    }
}
