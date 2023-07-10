package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.controllers.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

}
