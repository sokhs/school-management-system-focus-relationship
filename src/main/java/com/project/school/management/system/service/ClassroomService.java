package com.project.school.management.system.service;

import com.project.school.management.system.entity.Classroom;
import com.project.school.management.system.repository.ClassroomRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClassroomService {

    @Autowired
    private final ClassroomRepo repo;

    public Classroom save(Classroom classroom) {
        return repo.save(classroom);
    }

    public Classroom findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Classroom not found"));
    }

}
