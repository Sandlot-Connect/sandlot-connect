package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Request;
import com.codeup.sandlotconnect.models.Team;
import com.codeup.sandlotconnect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Request, Long> {
    Request findRequestById(long id);
}
