package com.example.test.repository;

import com.example.test.entity.Course;

public interface CourseRepository extends BaseRepository<Course, Integer> {
    Course findByName(String name);
}
