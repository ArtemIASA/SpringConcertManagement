package org.concertManagement.repo;

import org.concertManagement.entities.Finances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinancesRepository extends JpaRepository<Finances, UUID>{
}
