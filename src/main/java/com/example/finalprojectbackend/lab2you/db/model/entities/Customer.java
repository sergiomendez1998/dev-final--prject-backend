package com.example.finalprojectbackend.lab2you.db.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cui;
    private String name;
    private String lastName;
    private String Nit;
    private String address;
    private String phoneNumber;
    private String gender;
    private String occupation;
    private LocalDateTime   createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @OneToMany (mappedBy = "customer")
    private List<Request> requests = new ArrayList<>();
    @PrePersist

    public void prePersist() {
        createdAt = LocalDateTime.now();
    }


}
