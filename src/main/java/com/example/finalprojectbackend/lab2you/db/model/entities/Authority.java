package com.example.finalprojectbackend.lab2you.db.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class Authority extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String path;
    private String icon;

    @ManyToMany(mappedBy ="authorities" )
    private List<Role> roles;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authority_modules", joinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
    private List<Module> modules = new ArrayList<>();
}
