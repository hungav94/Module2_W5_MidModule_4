package com.codegym.service.impl;

import com.codegym.model.Classroom;
import com.codegym.repository.ClassroomRepository;
import com.codegym.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAllByClassroom() {
        return classroomRepository.findAll();
    }

    @Override
    public Page<Classroom> findAll(Pageable pageable) {
        return classroomRepository.findAll(pageable);
    }

    @Override
    public Classroom findAllById(Long id) {
        return classroomRepository.findOne(id);
    }

    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public void delete(Long id) {
        classroomRepository.delete(id);
    }
}
