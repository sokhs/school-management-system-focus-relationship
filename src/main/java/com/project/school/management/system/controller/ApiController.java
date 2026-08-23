package com.project.school.management.system.controller;

import com.project.school.management.system.common.status.AttendanceStatus;
import com.project.school.management.system.entity.Attendance;
import com.project.school.management.system.entity.Classroom;
import com.project.school.management.system.entity.Enrollment;
import com.project.school.management.system.entity.Student;
import com.project.school.management.system.service.AttendanceService;
import com.project.school.management.system.service.ClassroomService;
import com.project.school.management.system.service.EnrollmentService;
import com.project.school.management.system.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private final StudentService studentService;
    @Autowired
    private final AttendanceService attendanceService;
    @Autowired
    private final ClassroomService classroomService;
    @Autowired
    private final EnrollmentService enrollmentService;

    @PostMapping
    public void save() {

        // To Save Enrollment
        Student student = studentService.findById(1L);
        Classroom classroom = classroomService.findById(1L);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setClassroom(classroom);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollmentService.save(enrollment);

        // To Save Attendance
        Attendance attendance = new Attendance();
        attendance.setStudentId(3L);
        attendance.setClassroomId(9L);
        attendance.setAttendanceDate(LocalDate.now());
        attendance.setStatus(AttendanceStatus.PRESENT);
        attendanceService.save(attendance);

    }

}
