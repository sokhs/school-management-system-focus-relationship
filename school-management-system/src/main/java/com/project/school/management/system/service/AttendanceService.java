package com.project.school.management.system.service;

import com.project.school.management.system.entity.Attendance;
import com.project.school.management.system.repository.AttendanceRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceService {

    @Autowired
    private final AttendanceRepo repo;

    public Attendance save(Attendance req){
        return repo.save(req);
    }

}
