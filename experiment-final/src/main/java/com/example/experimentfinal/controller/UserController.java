package com.example.experimentfinal.controller;

import com.example.experimentfinal.entity.Course;
import com.example.experimentfinal.entity.Homework;
import com.example.experimentfinal.entity.User;
import com.example.experimentfinal.service.CourseService;
import com.example.experimentfinal.service.HomeworkService;
import com.example.experimentfinal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private HomeworkService homeworkService;

    @GetMapping("/main")
    public Map getMain(@RequestAttribute int uid, @RequestAttribute int aid) {
        List<Course> courses = null;
        if (aid == User.USER_AUTHORITY) {
            courses = courseService.listStudentCourses(uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            courses = courseService.listTeacherCourses(uid);
        }

        return Map.of("courses", courses);
    }
    @GetMapping("/courses/{cid}")
    public Map getCourse(@PathVariable int cid, @RequestAttribute int uid,
                         @RequestAttribute int aid) {
        Course course = null;
        if (aid == User.USER_AUTHORITY) {
            course = courseService.getStudentCourse(cid, uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            course = courseService.getTeacherCourse(cid, uid);
        }
        // map.of()方法，中的值不能为null，此处也可以抛400异常
        Optional.ofNullable(course)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "资源不存在"));

        return Map.of("course", course);
    }

    @GetMapping("/courses/{cid}/homeworks")
    public Map getHomeworks(@PathVariable int cid,
                            @RequestAttribute int uid,
                            @RequestAttribute int aid) {
        List<Homework> homeworks = null;
        if (aid == User.USER_AUTHORITY) {
            homeworks = homeworkService.listStudentHomeworks(cid, uid);
        }
        if (aid == User.ADMIN_AUTHORITY) {
            homeworks = homeworkService.listTeacherHomeworks(cid, uid);
        }
        return Map.of("homeworks", homeworks);
    }
}
