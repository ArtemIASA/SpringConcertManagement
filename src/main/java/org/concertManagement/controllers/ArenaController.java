package org.concertManagement.controllers;

import org.concertManagement.entities.Arena;
import org.concertManagement.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("arenas")
public class ArenaController {
    private final ArenaService arenaService;

    @Autowired
    public ArenaController(ArenaService arenaService){
        this.arenaService = arenaService;
    }

    @PostMapping
    public ResponseEntity<Void> addArena(@RequestBody Arena arena){
        arenaService.addArena(arena);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteArena(@RequestBody Arena arena){
        arenaService.deleteArena(arena);
        return ResponseEntity.ok().build();
    }
}
