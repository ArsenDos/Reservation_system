package kz.com.reservation.reservation.task.entity;

import jakarta.persistence.*;
import kz.com.reservation.reservation.task.enums.TaskPriority;
import kz.com.reservation.reservation.task.enums.TaskStatus;

import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
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
    @Column(name="deadline_date")
    LocalDateTime deadlineDate;
    @Column(name="priority")
    @Enumerated(EnumType.STRING)
    TaskPriority priority;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Long assignedId) {
        this.assignedId = assignedId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}
