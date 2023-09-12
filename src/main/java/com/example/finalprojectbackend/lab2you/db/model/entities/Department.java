package com.example.finalprojectbackend.lab2you.db.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class Department extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
