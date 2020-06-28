package com.example.test.service;

import com.example.test.entity.Course;
import com.example.test.entity.Teacher;
import com.example.test.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository cr;
    @Autowired
    TeacherService ts;
    public Course addCourse(Course course) {
       return cr.save(course);
    }
    public void deleteCourse(int id) {
        cr.deleteById(id);
    }
    public List<Course> listCourse() {
        return cr.findAll();
    }
    public Course getCourse(int id) {
       return cr.findById(id).orElse(null);
    }
    public Course updateCourse(Course course) {
        return cr.save(course);
    }
    public void addCourseByTeacher(Course course,int tid) {
        Teacher t = ts.getTeacher(tid);
        course.setTeacher(t);
        cr.save(course);
    }

}
