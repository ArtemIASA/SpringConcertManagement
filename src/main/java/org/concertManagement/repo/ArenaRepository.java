package org.concertManagement.repo;

import org.concertManagement.entities.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArenaRepository extends JpaRepository<Arena, UUID> {
}
