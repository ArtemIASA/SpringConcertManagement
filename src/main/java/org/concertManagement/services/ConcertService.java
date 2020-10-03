package org.concertManagement.services;

import org.concertManagement.entities.Concert;
import org.concertManagement.repo.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;


@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    @Autowired
    public ConcertService(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Transactional
    public void addConcert(Concert concert){
        concertRepository.save(concert);
    }

    @Transactional
    public void deleteConcert(Concert concert){
        concertRepository.delete(concert);
    }

    @Transactional
    public UUID getConcertId(Concert concert){
        return concertRepository.findByName(concert.getName()).getId();
    }

}

