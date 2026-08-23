package com.project.school.management.system.service;

import com.project.school.management.system.entity.Enrollment;
import com.project.school.management.system.repository.EnrollmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EnrollmentService {

    @Autowired
    private final EnrollmentRepo repo;

    public Enrollment save(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    public Enrollment findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Enrollment not found"));
    }
}
