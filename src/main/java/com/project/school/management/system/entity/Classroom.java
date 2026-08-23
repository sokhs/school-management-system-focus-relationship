package com.project.school.management.system.entity;

import com.project.school.management.system.common.status.ClassroomStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Classroom.TABLE_NAME)
public class Classroom {

    public static final String TABLE_NAME = "classrooms";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String grade;

    @Column(name = "academic_year_id")
    private Long academicYearId = 0L;

    private Integer capacity = 0;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ClassroomStatus status = ClassroomStatus.ACTIVE;

    @OneToMany(mappedBy = Attendance.Fields.classroom)
    private List<Attendance> attendances;


}
