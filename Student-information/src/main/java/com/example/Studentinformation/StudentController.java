package com.example.Studentinformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody() Student student){
        studentService.addStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("rollNo") int rollNo){
        Student s=new Student();
        s=studentService.getStudentInfo(rollNo);
        return new ResponseEntity(s,HttpStatus.OK);
    }
    @PutMapping("/update-studentInfo")
    public ResponseEntity<String> updateStudentInfo(@RequestParam("rollNo") int id,@RequestParam("name") String name,@RequestParam("mobileNo") String mobileNo,@RequestParam("standard") int standard){
        String status=studentService.updateStudentInfo(id,name,mobileNo,standard);
        return new ResponseEntity(status,HttpStatus.OK);
    }
    @DeleteMapping("/delete-student")
    public ResponseEntity<String> deleteStudent(@RequestParam("rollNo") int rollNo){
        studentService.deleteStudent(rollNo);
        return new ResponseEntity("Student Entry Deleted Successfully",HttpStatus.OK);
    }

}
