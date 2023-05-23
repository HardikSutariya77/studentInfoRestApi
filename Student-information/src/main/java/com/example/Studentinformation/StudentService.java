package com.example.Studentinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int rollNo) {
        studentRepository.deleteById(rollNo);
    }

    public String updateStudentInfo(int id, String name, String mobileNo, int standard) {

        if(studentRepository.existsById(id)){
            Student s=studentRepository.findById(id).get();
            s.setName(name);
            s.setMobileNo(mobileNo);
            s.setStandard(standard);
            studentRepository.save(s);
            return "student info updated successfully";

        }
        else{
            return "student entry is not present";
        }
    }

    public Student getStudentInfo(int rollNo) {
        Student s=studentRepository.findById(rollNo).get();
        return s;
    }
}
