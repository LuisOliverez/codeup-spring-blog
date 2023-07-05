package com.codeup.codeupspringblog.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Post {

        private String title;
        private String body;
}
