/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.co.bankingsystem.piggybank.entities.ClientAccount;
import za.co.bankingsystem.piggybank.entities.ClientTransactions;


/**
 *
 * @author ayuk
 */
@ManagedBean(name = "transactions")
public class TransactionApplicationController {

    private String transactionType;
    private long accNumber;
    private double amount;
    private String references;
    private double balance;
    private ClientAccount account;
    private ClientTransactions trans;

    public TransactionApplicationController(){
        
    }
    
    public long getAccountNumber() {
        return accNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accNumber = accountNumber;
    }

    
    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ClientTransactions getTrans() {
        return trans;
    }

    public void setTrans(ClientTransactions trans) {
        this.trans = trans;
    }

    

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTransactionType() {
        return transactionType;
    }

   
   

    public ClientAccount getAccount() {
        return account;
    }

    public void setAccount(ClientAccount account) {
        this.account = account;
    }

    public String dlink() {

        String depositLink = "depositPage.xhtml";

        return depositLink;
    }

    public String wlink() {

        String withdrawLink = "withdrawPage.xhtml";

        return withdrawLink;

    }

    public String checkLink() {

        String checkBalanceLink = "checkBalance.xhtml";

        return checkBalanceLink;
    }

    /**
    public String depositCash(TransactionApplicationController transactions) {
        String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

        // Account account = new Account();
        try {
            em.getTransaction().begin();
            transactions.account = em.find(Account.class, accNumber);
            transactions.account.setBalance(transactions.account.getBalance() + amount);
            


            trans = new Transactionz("Deposit", amount,references, accNumber);
             
            
            em.persist(trans);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        return "clientOperationDetails.xhtml";
    }

* */
     public String depositCash(TransactionApplicationController transactions) {
        String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

        // Account account = new Account();
        try {

            em.getTransaction().begin();
            transactions.account = em.find(ClientAccount.class, accNumber);
            
            if(transactions.getAmount() % 2 != 0 ){
                return "noDepositingCoins.xhtml";
            }else{
                if(transactions.getAmount() < 50){
            return "belowDep.xhtml";
                }else{
                        
            transactions.account.setBalance(transactions.account.getBalance() + amount);
            trans = new ClientTransactions("Withdrawals",accNumber,amount,references);
            em.persist(trans);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        return "clientOperationDetails.xhtml";
    }
    
    
    

    public String withdrawCash(TransactionApplicationController transactions) {
        String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

        // Account account = new Account();
        try {

            em.getTransaction().begin();
            transactions.account = em.find(ClientAccount.class, accNumber);
            
            if(transactions.getAmount() % 2 != 0 ){
                return "invalidAmount.xhtml";
            }else{
                if(transactions.getAmount() > transactions.account.getBalance()){
            return "limitedFunds.xhtml";
                }else{
                        
            transactions.account.setBalance(transactions.account.getBalance() - amount);
            trans = new ClientTransactions("Withdrawals",accNumber,amount,references );
            
            
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        return "clientOperationDetails.xhtml";
    }

    public String balance() {
        String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

        // Account account = new Account();
        try {
            em.getTransaction().begin();
            List<ClientAccount> acc = em.createQuery("SELECT a FROM Account a").getResultList();

            for (int a = 0; a < acc.size(); a++) {
                if (accNumber == acc.get(a).getAccountNumber()) {

                    account = acc.get(a);
                    return "displayAccountDetails.xhtml";
                }
            }

        } catch (Exception e) {

        }
        return "customerMenu.xhtml";
    }

}
