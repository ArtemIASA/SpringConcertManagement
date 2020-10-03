package org.concertManagement.controllers;

import org.concertManagement.entities.Concert;
import org.concertManagement.services.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("concerts")
public class ConcertController {
    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService){
        this.concertService = concertService;
    }

    @PostMapping
    public ResponseEntity<Void> addConcert(@RequestBody Concert concert){
        concertService.addConcert(concert);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteConcert(@RequestBody Concert concert){
        concertService.deleteConcert(concert);
        return ResponseEntity.ok().build();
    }

}
