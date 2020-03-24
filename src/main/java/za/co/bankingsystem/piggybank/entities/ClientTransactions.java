/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ayuk
 */
@Entity
public class ClientTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    private String type;
    private long accountNumber;
    private double amount;
    private String dateTime;
    private String reference;

    public ClientTransactions() {
        LocalDateTime date = LocalDateTime.now();
        this.dateTime = date.toString();
    }

    public ClientTransactions(String type, long accountNumber, double amount, String reference) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.reference = reference;
        LocalDateTime date = LocalDateTime.now();
        this.dateTime = date.toString();
    }
    
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    
    public Integer getId() {
        return transactionId;
    }

    public void setId(Integer id) {
        this.transactionId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the transactionId fields are not set
        if (!(object instanceof ClientTransactions)) {
            return false;
        }
        ClientTransactions other = (ClientTransactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClientTransactions{" + "transactionId=" + transactionId + ", type=" + type + ", accountNumber=" + accountNumber + ", amount=" + amount + ", dateTime=" + dateTime + ", reference=" + reference + '}';
    }

  
    
}
