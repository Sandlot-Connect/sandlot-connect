package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);
    List<User> findAllByTeam(Team team);
}
