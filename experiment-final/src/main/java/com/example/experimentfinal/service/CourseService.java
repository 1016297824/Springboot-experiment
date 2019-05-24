package com.example.experimentfinal.service;

import com.example.experimentfinal.entity.Course;
import com.example.experimentfinal.repository.CourseDetailRepoistory;
import com.example.experimentfinal.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseDetailRepoistory courseDetailRepoistory;

    public List<Course> listTeacherCourses(int tid) {
        return courseRepository.list(tid);
    }

    public List<Course> listStudentCourses(int sid) {
        return courseDetailRepoistory.list(sid);
    }

    public Course addCourse(Course course) {
        courseRepository.save(course);
        return courseRepository.refresh(course);
    }

    public Course getTeacherCourse(int cid, int tid) {
        return courseRepository.find(cid, tid);
    }

    public Course getStudentCourse(int cid, int sid) {
        return courseDetailRepoistory.find(cid, sid);
    }
}
