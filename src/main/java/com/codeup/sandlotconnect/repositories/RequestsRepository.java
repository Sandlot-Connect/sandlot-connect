package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Request;
import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestsRepository extends JpaRepository<Request, Long> {
    Request findRequestById(long id);
    Request findRequestByUserAndTeamAndCancelled(User user, Team team, boolean cancelled);
    List<Request> findByUserAndStatusAndCancelledFalse(User user, String status);
    Request findRequestByUser(User user);
}
