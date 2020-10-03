package org.concertManagement.repo;

import org.concertManagement.entities.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ConcertRepository extends JpaRepository<Concert, UUID> {
    Concert findByName(String name);
}
