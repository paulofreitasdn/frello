package br.com.company.frello.repository;

import br.com.company.frello.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}