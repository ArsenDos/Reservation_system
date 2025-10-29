package kz.com.reservation.reservation.task.repository;

import kz.com.reservation.reservation.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
