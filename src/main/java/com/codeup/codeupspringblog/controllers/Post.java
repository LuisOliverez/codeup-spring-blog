package com.codeup.codeupspringblog.controllers;

import jakarta.persistence.*;
import lombok.*;
@Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString

    @Entity

    @Table(name = "posts")
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, length = 100)
        private String title;//title of post

        @Column(nullable = false, length = 1000)
        private String body;//body of post
}
