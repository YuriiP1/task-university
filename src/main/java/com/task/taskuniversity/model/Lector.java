package com.task.taskuniversity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lector_department",
            joinColumns = {@JoinColumn(name = "lector_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")}
    )
    private List<Department> departments = new ArrayList<>();

    public Lector() {
    }

    public Lector(String name, Degree degree) {
        this.name = name;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", departments=" + departments +
                '}';
    }
}
