/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bir.parser;

/**
 *
 * @author nammar
 */
import WebServices.webServices;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class TestParsingWithJSON {

    private static JSONTokener jsonOut;
    private static JSONTokener jsonOut2;
    public static   ArrayList < userInformation> userInfo = new ArrayList <>();
    public static ArrayList <ArrayList<userInformation>> ListFriends = new ArrayList();
    public static JSONArray relation;
    public static  JSONArray personList;
    public static void main(String myHelpers[]) throws JSONException, IOException {
                     
      Method();
     /*    String id1;String id2 ;
          System.out.println("Relation Between Users:");
          
     for (int i=0;i<relation.length();i++){
            JSONObject relat = relation.getJSONObject(i);
           id1=  (String) relat.get("friend_id1");
         System.out.println( id1 );
           webServices web = new  webServices();
      web.RetrieveList(id1);
          System.out.println(); 
     }*/
     
            }
    
    public static void Method() throws IOException, JSONException{         
                File f = new File("C:/Users/LENOVO/Documents/NetBeansProjects/Assignment2/src/java/edu/bir/parser/user.json");
                File f2= new File("C:/Users/LENOVO/Documents/NetBeansProjects/Assignment2/src/java/edu/bir/parser/relation.json");
                  
                    // for read user file
                     String jsonString = readFile(f.getPath());
                     jsonOut = new JSONTokener(jsonString);
                     JSONObject output = new JSONObject(jsonOut);
                    JSONObject docs = output.getJSONObject("user");
                     personList = (JSONArray) docs.get("person");

                    // for read relation file
                     String jsonString2 = readFile(f2.getPath());   
                     jsonOut2 = new JSONTokener(jsonString2);
                     JSONObject output2 = new JSONObject(jsonOut2);
                     JSONObject docs2 = output2.getJSONObject("Relations");
                     relation = (JSONArray) docs2.get("friendly");

        
              System.out.println("Data for All Users:");
              System.out.println("ID \t Name \t      Last_Name \t   Address  \t\t Location");
            
             for (int i=0;i<personList.length();i++){
                  
            JSONObject person = personList.getJSONObject(i);
            
        
                 String location =   (String)person.get("location");
                 String [] xy =  location.split(",");  
                 String address = (String)person.get("Address");
                 String []city_country = address.split("_");
                 String name  = (String)person.get("name");
                 String []l_name = name.split("_");
                 
            userInfo.add(new userInformation((String) person.get("ID"),name
                    ,new Address (city_country [0],city_country [1])
                    ,new location(xy[0],xy[1])));
            
          
            System.out.print(person.get("ID")+ "\t"); 
            System.out.print(l_name[0]+"\t\t" );
            System.out.print(l_name[1]+"\t\t" );
            System.out.print(city_country [0] +"-"+city_country [1]+"\t");
            System.out.print(xy[0]+ ","+xy[1]);
            
            System.out.println();
    }
         
      }

    private  static String readFile(String file) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
       StringBuilder stringBuilder = new StringBuilder();
       // String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
          //  stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }

    
}
