package br.com.company.frello.domain.task;

public record ListTask(Long id, String title, String text) {

    public ListTask(Task task) {
        this(task.getId(), task.getTitle(), task.getText());
    }
}