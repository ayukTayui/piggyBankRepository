/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ayuk
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientId;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String emailAddress;
    private String nationality;
    private long telephone;

    @OneToMany
    private List<ClientAccount> accounts;

    public Client(String name, String surname, String dateOfBirth, String emailAddress, String nationality, long telephone, List<ClientAccount> accounts) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.nationality = nationality;
        this.telephone = telephone;
        this.accounts = accounts;
    }

    public Client() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public List<ClientAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ClientAccount> accounts) {
        this.accounts = accounts;
    }
    
    
    
    public Integer getId() {
        return clientId;
    }

    public void setId(Integer id) {
        this.clientId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the clientId fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + ", nationality=" + nationality + ", telephone=" + telephone + ", accounts=" + accounts + '}';
    }

  
}
