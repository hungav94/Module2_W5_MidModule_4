package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findAllByClassroom(Pageable pageable);

    Page<Student> findAllByFirstName(String firstName, Pageable pageable);

    Iterable<Student> findAllByClassroom(Student student);
}
