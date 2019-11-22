package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Iterable<Student> findAllByClassroom(Student student);

    Page<Student> findAllByClassroom(Pageable pageable);

    Page<Student> findAllByFirstName(String firstName, Pageable pageable);

    Page<Student> findAll(Pageable pageable);

    Student findAllById(Long id);

    void save(Student student);

    void delete(Long id);
}
