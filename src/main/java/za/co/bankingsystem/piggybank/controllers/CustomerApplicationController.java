/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.controllers;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.co.bankingsystem.piggybank.entities.Card;
import za.co.bankingsystem.piggybank.entities.Client;
import za.co.bankingsystem.piggybank.entities.ClientAccount;



/**
 *
 * @author ayuk
 */
@ManagedBean(name="customer")
public class CustomerApplicationController {
    
    private int clientId;
    private  String name;
    private String surname;
    private String dateOfBirth;
    private String emailAddress;
    private String nationality;
    private long telephone;
    
    private long cardNumber;
    private String cardType;
    private String cardStatus;
    private int pin;
    private Card card;
    
    private String accountType;
    private double balance;
    private String dateCreatedAccount;
    private String accountStatus;
    private ClientAccount account;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

    List<ClientAccount> accounts = new ArrayList<>();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
   
    
   
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDateCreatedAccount() {
        return dateCreatedAccount;
    }

    public void setDateCreatedAccount(String dateCreatedAccount) {
        this.dateCreatedAccount = dateCreatedAccount;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ClientAccount getAccount() {
        return account;
    }

    public void setAccount(ClientAccount account) {
        this.account = account;
    }

    
    public List<ClientAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ClientAccount> accounts) {
        this.accounts = accounts;
    }

    
    
    
    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
    
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getNationality() {
        return nationality;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
       
    
    public String persistCustomerDetails() {
                String jpaName = "Persistence";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
		EntityManager em = emf.createEntityManager();
        
      
                
         em.getTransaction().begin();
       Client client = new Client(name,surname,dateOfBirth,emailAddress,nationality,telephone,accounts);
      ClientAccount acc = new ClientAccount(this.accountType,this.accountStatus,this.balance,this.card);
       Card cardz = new Card(cardType,cardStatus, pin,acc);
         
        this.account = acc;
        this.card = cardz;
        
       
       client.getAccounts().add(acc);
       acc.setCard(card);
       cardz.setAccount(account);
       
            em.persist(client);
           em.persist(cardz);
           em.persist(acc);
            
            em.getTransaction().commit();
                                 
            return "clientAccountDetails.xhtml";
    }

    public String idValidation(){
        String jpaName = "Persistence";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
	EntityManager em = emf.createEntityManager();
        ClientAccount acc = em.find(ClientAccount.class,clientId);
            
        if(acc.getId() == clientId){
            return "existingClient.xhtml";
        }else{
            
            return "invalidIdNumber.xhtml";
        
        }
       
 }
    public String createOtherAccounts(){
        String jpaName = "Persistence";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
	EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        account = new ClientAccount(accountType, accountStatus, balance, card);
        card = new  Card(cardType,cardStatus, pin,account);         
                
                account.setCard(card);
                card.setAccount(account);
                 em.persist(account);
                 em.persist(card);
        em.getTransaction().commit();
                
                
     return "clientAccountDetails.xhtml"; 
    }
   

}

 
    

    
 
    
    

