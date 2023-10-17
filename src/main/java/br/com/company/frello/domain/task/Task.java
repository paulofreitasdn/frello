package br.com.company.frello.domain.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    public Task(TaskData data) {
        title = data.title();
        text = data.text();
    }

    public void updateTask(UpdateTask updateTask) {
        if (updateTask.title() != null) {
            title = updateTask.title();
        }
        if (updateTask.text() != null) {
            text = updateTask.text();
        }
    }
}