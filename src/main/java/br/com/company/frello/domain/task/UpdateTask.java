package br.com.company.frello.domain.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTask(@NotNull Long id, @NotBlank String title, @NotBlank String text) {
}