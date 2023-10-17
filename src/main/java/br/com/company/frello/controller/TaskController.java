package br.com.company.frello.controller;

import br.com.company.frello.domain.task.ListTask;
import br.com.company.frello.domain.task.Task;
import br.com.company.frello.domain.task.TaskData;
import br.com.company.frello.domain.task.UpdateTask;
import br.com.company.frello.repository.TaskRepository;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping("/register")
    @Transactional
    public void register(@RequestBody @Valid TaskData data) {
        repository.save(new Task(data));
    }

    @GetMapping("/list")
    public Page<ListTask> list(@PageableDefault(sort = {"title"}) Pageable pagination) {
        return repository.findAll(pagination).map(ListTask::new);
    }

    @PutMapping("/update")
    @Transactional
    public void update(@RequestBody @Valid UpdateTask updateTask) {
        Task task = repository.getReferenceById(updateTask.id());
        task.updateTask(updateTask);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}