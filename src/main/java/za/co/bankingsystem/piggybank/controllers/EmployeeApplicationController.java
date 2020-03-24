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
import za.co.bankingsystem.piggybank.entities.Employee;
import za.co.bankingsystem.piggybank.entities.LoginDetails;

/**
 *
 * @author ayuk
 */
@ManagedBean(name="employee")
public class EmployeeApplicationController {
    
    private int id ;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String position;
    private Employee employee;
    private LoginDetails loginDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }

   

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String displayEmployeeDetails(){
         String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

       
        try {
            em.getTransaction().begin();
            List<Employee> log = em.createQuery("SELECT l FROM Employee l").getResultList();

            for(int a=0; a<log.size(); a++){
                if(id == log.get(a).getEmployeeId())
                {
                    loginDetails = log.get(a).getLoginDetails();
                    return "loginDetails.xhtml";
                }
            }

        } catch (Exception e) {

        }
        
        
        
        
        
        return "invalidLogin.xhtml";
    }
   
   
    public String persistEmployeeDetails() {
		String jpaName = "Persistence";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
		EntityManager em = emf.createEntityManager();
                
                                
         em.getTransaction().begin();
       // try {

         
         Employee emp = new Employee(name,surname,position,loginDetails);
         LoginDetails logIn = new LoginDetails(username,password,emp);
         
         employee = emp;
         loginDetails = logIn;
         
            employee.setLoginDetails(loginDetails);
            loginDetails.setEmployee(employee);
            
            
            
              em.persist(logIn);
            em.persist(emp);
          
            
            em.getTransaction().commit();            
       // } catch (Exception e) {
       //     em.getTransaction().rollback();
      //  } 
    return "displayEmployeeDetails.xhtml";
    }
    
   
    
    
    
    
}
