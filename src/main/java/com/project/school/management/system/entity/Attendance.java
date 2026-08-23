package com.project.school.management.system.entity;

import com.project.school.management.system.common.status.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@FieldNameConstants
@Table(name = Attendance.TABLE_NAME)
public class Attendance {

    public static final String TABLE_NAME = "attendance";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "classroom_id", nullable = false)
    private Long classroomId;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private AttendanceStatus status;

    @Column(name = "remarks", length = 255)
    private String remark;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Classroom classroom;
}
