package com.codeup.codeupspringblog.controllers;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

}