package com.raja.studentdetail.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="studentformtest")
public class Student {

    @Id
    @Column(unique = true)
    private String email; // Primary Key

    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne
//    @JoinColumn(name = "College_id")
    @JoinColumn
    private College college;





}
