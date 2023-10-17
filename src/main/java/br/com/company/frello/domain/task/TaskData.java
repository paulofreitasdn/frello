package br.com.company.frello.domain.task;

import jakarta.validation.constraints.NotBlank;

public record TaskData(@NotBlank String title, @NotBlank String text) {
}