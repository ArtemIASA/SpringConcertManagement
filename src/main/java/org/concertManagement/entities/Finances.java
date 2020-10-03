package org.concertManagement.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "finances")
public class Finances {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Concert concert;

    @Column(name = "expenses")
    private int expenses;

    @Column(name = "profit")
    private int profit;

    @Column(name = "revenue")
    private int revenue;

    public Finances() {
        this.expenses = 0;
        this.profit = 0;
        this.revenue = 0;
    }

    public void setExpenses(int expenses){
        this.expenses = expenses;
        this.revenue = profit - expenses;
    }

    public void setProfit(int profit){
        this.profit = profit;
        this.revenue = profit - expenses;
    }

    public int getExpenses(){
        return expenses;
    }

    public int getProfit(){
        return profit;
    }
}
