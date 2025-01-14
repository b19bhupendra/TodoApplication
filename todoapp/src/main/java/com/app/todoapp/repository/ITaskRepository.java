package com.app.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todoapp.models.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

}
