package com.Ashutosh.Spring_Security_Demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student_Details")
@Data
public class Student {
    @Id
    private int id;
    private String name;
    private String technology;

}
