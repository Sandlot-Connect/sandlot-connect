package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {

}
