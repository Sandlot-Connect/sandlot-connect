package com.codeup.sandlotconnect.repositories;

import com.codeup.sandlotconnect.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Request, Long> {

}
