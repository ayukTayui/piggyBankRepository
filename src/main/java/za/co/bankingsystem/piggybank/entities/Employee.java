/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bankingsystem.piggybank.entities;

import java.io.Serializable;
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
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String name;
    private String surname;
    private String position;
    
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private LoginDetails loginDetails;

    public Employee() {
    }

    public Employee(String name, String surname, String position, LoginDetails loginDetails) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.loginDetails = loginDetails;
    }
    
    
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }
    
    public Integer getId() {
        return employeeId;
    }

    public void setId(Integer id) {
        this.employeeId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the employeeId fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.bankingsystem.piggybank.entities.Employee[ id=" + employeeId + " ]";
    }
    
}
