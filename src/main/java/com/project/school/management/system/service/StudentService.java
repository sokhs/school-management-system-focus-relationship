package com.project.school.management.system.service;

import com.project.school.management.system.entity.Student;
import com.project.school.management.system.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepo repo;

    public Student save(Student req) {
        return repo.save(req);
    }

    public Student findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found"));
    }
}
