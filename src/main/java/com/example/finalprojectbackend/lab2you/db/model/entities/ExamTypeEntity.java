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
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "exam_types")
@NoArgsConstructor
public class ExamTypeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany (mappedBy = "examType")
    private List<RequestEntity> requestEntities = new ArrayList<>();

    public ExamTypeEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
 }