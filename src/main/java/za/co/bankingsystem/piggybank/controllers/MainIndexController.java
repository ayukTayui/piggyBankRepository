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
@ManagedBean(name="main")
public class MainIndexController {
    
    
    public String path(){
        
        String path = "employeeRegistration.xhtml";
        
        return path;
    }
    
    public String path2(){
        
        String path="login.xhtml";
        
        return path;
    }
    
    
}
