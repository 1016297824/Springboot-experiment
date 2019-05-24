package com.example.experimentfinal.controller;

import com.example.experimentfinal.entity.Course;
import com.example.experimentfinal.entity.Homework;
import com.example.experimentfinal.entity.User;
import com.example.experimentfinal.service.CourseService;
import com.example.experimentfinal.service.HomeworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/courses")
    public Map postCourse(@RequestBody Course course, @RequestAttribute int uid) {
        course.setTeacher(new User(uid));
        courseService.addCourse(course);
        return Map.of("courses", courseService.listTeacherCourses(uid));
    }

    @PostMapping("/courses/{cid}/homeworks")
    public Map postHomework(@PathVariable int cid,
                            @RequestAttribute int uid,
                            @RequestBody Homework homework) {
        homeworkService.addHomework(homework);
        return Map.of("homeworks", homeworkService.listTeacherHomeworks(cid, uid));
    }
}
