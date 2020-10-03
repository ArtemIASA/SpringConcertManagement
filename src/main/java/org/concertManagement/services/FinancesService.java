package org.concertManagement.services;


import org.concertManagement.entities.Finances;
import org.concertManagement.repo.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FinancesService {
    private final FinancesRepository financesRepository;

    @Autowired
    public FinancesService(FinancesRepository financesRepository) {
        this.financesRepository = financesRepository;
    }

    @Transactional
    public void changeProfit(UUID concertId, int toAdd){
        Finances finances = financesRepository.findById(concertId).get();
        financesRepository.delete(finances);
        finances.setProfit(finances.getProfit() + toAdd);
        financesRepository.save(finances);
    }

    @Transactional
    public void changeExpenses(UUID concertId, int toAdd){
        Finances finances = financesRepository.findById(concertId).get();
        financesRepository.delete(finances);
        finances.setExpenses(finances.getExpenses() + toAdd);
        financesRepository.save(finances);
    }

}
