package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
