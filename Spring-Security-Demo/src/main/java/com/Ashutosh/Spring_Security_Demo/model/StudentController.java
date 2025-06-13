package com.Ashutosh.Spring_Security_Demo.model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(

            List.of(
                    new Student(1,"Ashutosh","java"),
                    new Student(2,"Vijay Sharma","Js"),
                    new Student(3,"Vijay Sharma",".Net")
            )
    );


    @GetMapping(path = "Students")
    public List<Student> getStudent(){
        for(int i=0;i<students.size();i++){
            System.out.println("List value is : "+students.get(i).getName());
            System.out.println("List value is : "+students.get(i).getId());
            System.out.println("List value is : "+students.get(i).getTechnology());
        }
        return students;

    }

    @PostMapping("student")
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        for(int i=0;i<students.size();i++){
            System.out.println("List value is : "+students.get(i).getName());
            System.out.println("List value is : "+students.get(i).getId());
            System.out.println("List value is : "+students.get(i).getTechnology());
        }
        return students;

    }

    @GetMapping("get-csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){

        return (CsrfToken) request.getAttribute("_csrf");

    }
}
