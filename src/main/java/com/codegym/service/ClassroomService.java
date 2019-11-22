package com.codegym.service;

import com.codegym.model.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClassroomService {

    Iterable<Classroom> findAllByClassroom();

    Page<Classroom> findAll(Pageable pageable);

    Classroom findAllById(Long id);

    void save(Classroom classroom);

    void delete(Long id);
}
