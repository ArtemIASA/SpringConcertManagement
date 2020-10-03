package org.concertManagement.services;

import org.concertManagement.repo.ArenaRepository;
import org.concertManagement.entities.Arena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    @Transactional
    public void addArena(Arena arena){
        arenaRepository.save(arena);
    }

    @Transactional
    public void deleteArena(Arena arena){
        arenaRepository.delete(arena);
    }
}
