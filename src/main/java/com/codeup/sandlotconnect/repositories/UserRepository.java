package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
