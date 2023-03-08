package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
//    List<Post> findAll
}
