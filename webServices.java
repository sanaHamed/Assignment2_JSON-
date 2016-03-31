/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import edu.bir.parser.TestParsingWithJSON;
import edu.bir.parser.userInformation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author LENOVO
 */
@WebService(serviceName = "webServices")
public class webServices {

  String id2="";
  String location= "";
   

    @WebMethod(operationName = "RetrieveList")
    public  String RetrieveList(@WebParam(name = "ID") String ID) throws JSONException, IOException {
        
        TestParsingWithJSON tst = new TestParsingWithJSON();
        TestParsingWithJSON.Method();
         
      
      
    for (int i=0;i<TestParsingWithJSON.userInfo.size();i++){
        if (TestParsingWithJSON.userInfo.get(i).id.equals(ID)){
            ArrayList <userInformation> user = new ArrayList();
            user.add(TestParsingWithJSON.userInfo.get(i));
             
               for (int j =0;j<TestParsingWithJSON.relation.length();j++){
            
            TestParsingWithJSON.ListFriends.add(new ArrayList());
              JSONObject relat = TestParsingWithJSON.relation.getJSONObject(j);
               
              if ((ID.equals(relat.get("friend_id1")) )){
                System.out.println( relat.get("friend_id2"));
                id2+= "ID: ("+(String) relat.get("friend_id2")+")";
                  
                  for (int k=0;k<TestParsingWithJSON.userInfo.size();k++){
                  if (TestParsingWithJSON.userInfo.get(k).id.equals(relat.get("friend_id1"))){
                  user.add(TestParsingWithJSON.userInfo.get(k));
                 

              }
                   if (TestParsingWithJSON.userInfo.get(k).id.equals(relat.get("friend_id2"))){
                  user.add(TestParsingWithJSON.userInfo.get(k));
                   id2 += "   "+  TestParsingWithJSON.userInfo.get(k).name+",";        
                  }
                  }}
                
                  else if ((ID.equals(relat.get("friend_id2")) )){
                  System.out.println( relat.get("friend_id1"));
                                 id2+=  "ID: ("+(String)relat.get("friend_id1")+")";
                     
                  for (int k=0;k<TestParsingWithJSON.userInfo.size();k++){
                  if (TestParsingWithJSON.userInfo.get(k).id.equals(relat.get("friend_id2"))){
                  user.add(TestParsingWithJSON.userInfo.get(k));
                    
                  }
                  if (TestParsingWithJSON.userInfo.get(k).id.equals(relat.get("friend_id1"))){
                  user.add(TestParsingWithJSON.userInfo.get(k));
                   id2 += "   "+  TestParsingWithJSON.userInfo.get(k).name+",";        
                  }
                  
                  }
             
           TestParsingWithJSON.ListFriends.add(user);
          }
           
        }
               
        }
        
     
       }
        return id2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showFriendLocation")
    public String showFriendLocation(@WebParam(name = "ID1") String ID1, @WebParam(name = "ID2") String ID2) throws IOException, JSONException {
        //TODO write your implementation code here:
       TestParsingWithJSON tst = new TestParsingWithJSON();
        TestParsingWithJSON.Method();
         
      
      
    for (int i=0;i<TestParsingWithJSON.userInfo.size();i++){
        if (TestParsingWithJSON.userInfo.get(i).id.equals(ID1)){
   
             location+= "ID1"+TestParsingWithJSON.userInfo.get(i).name
                   +"   "+TestParsingWithJSON.userInfo.get(i).address.city+","
                   +"   "+TestParsingWithJSON.userInfo.get(i).address.country+","
                   +"   "+TestParsingWithJSON.userInfo.get(i).l.x+","
                   +"   "+TestParsingWithJSON.userInfo.get(i).l.y+",";
        ;
             
        }
       if (TestParsingWithJSON.userInfo.get(i).id.equals(ID2)){

           location+= "ID2"+TestParsingWithJSON.userInfo.get(i).name
                   +"   "+TestParsingWithJSON.userInfo.get(i).address.city
                   +"   "+TestParsingWithJSON.userInfo.get(i).address.country
                   +"   "+TestParsingWithJSON.userInfo.get(i).l.x+","
                    +"   "+TestParsingWithJSON.userInfo.get(i).l.y+",";
            
               
        } 
        
     
       }
        return location;
    }

    
}
