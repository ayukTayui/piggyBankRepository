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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ayuk
 */
@Entity
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long cardNumber;
    private String cardType;
    private String cardStatus;
    private int pin;
    private String dateCreated;
    private String expiryDate;
        
    @OneToOne
    private ClientAccount clientAccount;

    public Card() {
        
        String generateAccountNumber = String.valueOf(new Random().nextInt()).substring(1);
        this.cardNumber= Long.parseLong(generateAccountNumber);
        LocalDate date = LocalDate.now();
        this.dateCreated = date.toString();
        LocalDate exDate = LocalDate.now().plusYears(4);
    }

    public Card(String cardType, String cardStatus, int pin, ClientAccount account) {
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.pin = pin;
        this.clientAccount = account;
        
        String generateAccountNumber = String.valueOf(new Random().nextInt()).substring(1);
        this.cardNumber= Long.parseLong(generateAccountNumber);
        LocalDate date = LocalDate.now();
        this.dateCreated = date.toString();
        LocalDate exDate = LocalDate.now().plusYears(4);
        
    }
    
    
    

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        
        this.dateCreated = dateCreated;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ClientAccount getAccount() {
        return clientAccount;
    }

    public void setAccount(ClientAccount account) {
        this.clientAccount = account;
    }
        
    
    
    public Long getId() {
        return cardNumber;
    }

    public void setId(Long id) {
        this.cardNumber = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardNumber != null ? cardNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardNumber == null && other.cardNumber != null) || (this.cardNumber != null && !this.cardNumber.equals(other.cardNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Card{" + "cardNumber=" + cardNumber + ", cardType=" + cardType + ", cardStatus=" + cardStatus + ", pin=" + pin + ", dateCreated=" + dateCreated + ", expiryDate=" + expiryDate + ", account=" + clientAccount + '}';
    }

    
    
}
