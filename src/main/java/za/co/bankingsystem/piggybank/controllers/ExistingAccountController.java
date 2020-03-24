/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.controllers;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author ayuk
 */
@ManagedBean(name = "existingAccount")
public class ExistingAccountController {
    
    private long accountNumber;
    private double amount;

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
    
    
    
	public double deposit(double currentBalance , double amount) {
	
		 currentBalance = currentBalance + amount;
		
		return currentBalance;
	}
	
	
	
	public double withdraw(double amount,double currentBalance) {
		
		currentBalance = currentBalance - amount;
		
		return currentBalance;
	}
	
        
    
}
