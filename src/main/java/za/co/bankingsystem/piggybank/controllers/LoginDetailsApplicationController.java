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
import za.co.bankingsystem.piggybank.entities.LoginDetails;

/**
 *
 * @author ayuk
 */
@ManagedBean(name = "login")
public class LoginDetailsApplicationController {

    private String username;
    private String password;

    private LoginDetails loginDetails;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String link() {

        String path = "customerMenu.xhtml";

        return path;
    }

    public String login() {
        String jpaName = "Persistence";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(jpaName);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            List<LoginDetails> signIn = em.createQuery("SELECT l FROM LoginDetails l").getResultList();
            int a = 0;
            for (a = 0; a < signIn.size(); a++) {
                if (signIn.get(a).getUsername().equals(username) && signIn.get(a).getPassword().equals(password)) {

                    return "customerMenu.xhtml";
                }

            }

            em.getTransaction().commit();
        } catch (Exception ex) {

        }
        return "invalidLogin.xhtml";
    }

}
