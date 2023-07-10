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
        private Long id;

        @Column(nullable = false)
        private String title;//title of post

        @Column
        private String body;//body of post

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;


}
