package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAllByClassroom(Student student) {
        return studentRepository.findAllByClassroom(student);
    }

    @Override
    public Page<Student> findAllByClassroom(Pageable pageable) {
        return studentRepository.findAllByClassroom(pageable);
    }

    @Override
    public Page<Student> findAllByFirstName(String firstName, Pageable pageable) {
        return studentRepository.findAllByFirstName(firstName, pageable);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findAllById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
