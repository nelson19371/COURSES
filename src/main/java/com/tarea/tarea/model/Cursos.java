package com.tarea.tarea.model;

import javax.persistence.*;

@Entity


public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @Column
   private String name;
    @Column
   private String instructor;
    @Column
   private String email;
    @Column
   private String image;

    public Cursos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
