/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bir.parser;

/**
 *
 * @author LENOVO
 */
public class userInformation {
    public String id; 
    public String name;
    public location l;
    public Address address;
    public  userInformation(){
    
}
    public userInformation (String id,String name , Address address,location l){
        this.id=id;
        this.name=name;
        this.address =address;
        this.l =l;
        
    }

   
  
   
}
