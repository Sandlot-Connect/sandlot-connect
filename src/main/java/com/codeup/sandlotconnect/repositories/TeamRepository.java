package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
Team findTeamById(long id);
}
