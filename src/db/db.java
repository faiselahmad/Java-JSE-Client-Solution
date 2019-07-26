/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class db {
     public static Connection c;
     public static Statement st;
     public static PreparedStatement insertUser;
     public static PreparedStatement getUser;
     public static PreparedStatement updateUser;
     public static PreparedStatement deleteUser;
    static{
              /* try{
                  Class.forName("oracle.jdbc.driver.OracleDriver");
              c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Faisel123","faisel123");
           st=c.createStatement();
           }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
         e.printStackTrace();*/
            
            
            
      try{
              Class.forName("com.mysql.jdbc.Driver");
              c=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtext13","root","incapp");
              st=c.createStatement();
  insertUser = c.prepareStatement("insert into admin_login (name,gender,dob,country,address,language) values(?,?,?,?,?,?)");             
  getUser=c.prepareStatement("select * from admin_login where name like ? ");
  updateUser=c.prepareStatement("update client_info set name=?,gender=?,dob=?,country=?,address=?,language=? where cid=?");
  deleteUser=c.prepareStatement("delete from admin_login where userid=?");
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
           
        }
}
}