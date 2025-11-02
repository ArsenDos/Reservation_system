package kz.com.reservation.reservation.task.service;

import kz.com.reservation.reservation.task.entity.Task;
import kz.com.reservation.reservation.task.enums.TaskStatus;
import kz.com.reservation.reservation.task.repository.TaskRepository;
import kz.com.reservation.reservation.task.service.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        log.info("[GET]Fetching all tasks");
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        log.info("[GET]Fetching task with id {}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> {
                    return new NotFoundException("Task not found");
                });
    }

    public Task createTask(Task task) {
        log.info("[CREATE]Creating task {}", task);
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {

        log.info("[UPDATE]Updating task {}", updatedTask);

        return taskRepository.findById(id)
                .map( existingTask -> {

                    if (!isValidTask(existingTask, updatedTask)) {
                        throw new IllegalStateException("Invalid status transition from " +
                                existingTask.getStatus() + " to " + updatedTask.getStatus());
                    }

                    existingTask.setStatus(updatedTask.getStatus());
                    existingTask.setPriority(updatedTask.getPriority());
            return taskRepository.save(existingTask);
        }).orElseThrow(() -> {
            return new NotFoundException("Task not found with id ");
        });
    }


    public void deleteTaskById(Long id) {
        log.info("[DELETE]Deleting task with id {}", id);
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException("Task not found with id ");
        }
         taskRepository.deleteById(id);
    }

    private boolean isValidTask(Task current , Task next) {
       return switch (current.getStatus()) {
            case CREATED:
                yield next.getStatus() == current.getStatus() ||
                        next.getStatus() == TaskStatus.IN_PROGRESS;
            case IN_PROGRESS:
                yield next.getStatus() == current.getStatus() ||
                        next.getStatus() == TaskStatus.DONE;
            case DONE:
                yield next.getStatus() == current.getStatus();
           default:
               throw new IllegalStateException("Unexpected value: " + current.getStatus());
       };
    }



    @Override
    public String toString() {
        return "TaskService{" +
                "taskRepository=" + taskRepository +
                '}';
    }

}
