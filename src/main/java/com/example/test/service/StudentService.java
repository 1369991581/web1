package com.example.test.service;




import com.example.test.entity.Direction;
import com.example.test.entity.Student;
import com.example.test.repository.DirectionRepository;
import com.example.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository sr;
    @Autowired
    TeacherService ts;
    @Autowired
    DirectionRepository dr;

    public Student getStudent(int sid) {
        return sr.find(sid);
    }
    public Direction getDirection(int did) {
        return dr.findById(did).orElse(null);
    }


}
