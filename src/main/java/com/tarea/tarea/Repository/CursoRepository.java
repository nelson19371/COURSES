package com.tarea.tarea.Repository;

import com.tarea.tarea.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface CursoRepository extends JpaRepository<Cursos,Integer> {
}
