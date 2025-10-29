package kz.com.reservation.reservation.task.service;

import kz.com.reservation.reservation.task.entity.Task;
import kz.com.reservation.reservation.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final TaskRepository taskRepository;


    public ReservationService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String getAllTasks() {
        return taskRepository.findAll().toString();
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(updatedTask.getStatus());
            task.setPriority(updatedTask.getPriority());
            return taskRepository.save(task);
        }).orElseThrow(() -> {
            return new RuntimeException("Task not found with id " + id);
        });
    }

    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
             new RuntimeException("Task not found with id " + id);
        }
         taskRepository.deleteById(id);
    }



    @Override
    public String toString() {
        return "ReservationService{" +
                "taskRepository=" + taskRepository +
                '}';
    }

}
