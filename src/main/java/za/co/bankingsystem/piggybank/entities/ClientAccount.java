/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ayuk
 */
@Entity
public class ClientAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long accountNumber;
    private String accountType;
    private String accountStatus;
    private String dateCreated;
    private double balance;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Card card;

    public ClientAccount() {
        String generateAccountNumber = String.valueOf(new Random().nextInt()).substring(1);
        this.accountNumber= Long.parseLong(generateAccountNumber);
        LocalDate date = LocalDate.now();
        this.dateCreated = date.toString();
        LocalDate exDate = LocalDate.now().plusYears(4);
    }

    public ClientAccount(String accountType, String accountStatus, double balance, Card card) {
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.balance = balance;
        this.card = card;
        
        String generateAccountNumber = String.valueOf(new Random().nextInt()).substring(1);
        this.accountNumber= Long.parseLong(generateAccountNumber);
        LocalDate date = LocalDate.now();
        this.dateCreated = date.toString();
        LocalDate exDate = LocalDate.now().plusYears(4);
    }
    
    
    

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    

    public Long getId() {
        return accountNumber;
    }

    public void setId(Long id) {
        this.accountNumber = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNumber != null ? accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the accountNumber fields are not set
        if (!(object instanceof ClientAccount)) {
            return false;
        }
        ClientAccount other = (ClientAccount) object;
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClientAccount{" + "accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", dateCreated=" + dateCreated + ", balance=" + balance + ", card=" + card + '}';
    }


}
