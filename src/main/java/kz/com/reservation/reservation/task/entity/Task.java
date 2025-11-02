package kz.com.reservation.reservation.task.entity;

import jakarta.persistence.*;
import kz.com.reservation.reservation.task.enums.TaskPriority;
import kz.com.reservation.reservation.task.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="task")
@Getter
@Setter
@ToString
public class Task {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   @Column(name="creator_id", nullable=false)
    Long creatorId;
    @Column(name="assigneed_id", nullable=false)
    Long assignedId;
    @Column(name="task_status")
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    @Column(name="created" , nullable=false)
    LocalDateTime created;
    @Column(name="deadline_date" , nullable=false)
    LocalDateTime deadlineDate;
    @Column(name="priority")
    @Enumerated(EnumType.STRING)
    TaskPriority priority;
}
