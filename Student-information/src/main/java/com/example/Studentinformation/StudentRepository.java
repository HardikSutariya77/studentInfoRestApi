package com.example.Studentinformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsById(int id);
}
