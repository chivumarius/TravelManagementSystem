package travel;

import java.sql.*;  

public class DBConnection {
    Connection c;
    Statement s;
    public DBConnection(){
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_management_system","root","");
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
