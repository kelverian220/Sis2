/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis2;
import java.sql.*;
/**
 *
 * @author USER
 */
public class user_verify {
    
    private static String user;
    private static String password;
    
    public static void setUser(String us){
        user=us;
    }
    
    public static void setPass(String pass){
        password=pass;
    }
    
    /*public static void show_data(){
        System.out.println(user);
        System.out.println(password);
    }*/
    public static String getUser(){
        return user;
    
    }
    
    public static String getPass(){
        return password;
    }
    
    public static boolean log(){
        boolean res=false;
        //String url = "jdbc:postgresql://192.168.43.84:5432/postgres";
        String url = "jdbc:mysql://sql5.freemysqlhosting.net:3306/sql5120455";
        //String username = "postgres";
        //String password = "admin";
        String username = "sql5120455";
        String pass = "EJTLyVveQj";
        //String driver = "org.postgresql.Driver";

        System.out.println("Connecting database...");
        
        
        
        try
            //Class.forName(driver);        
            (Connection con = DriverManager.getConnection(url, username, pass)){
            
            System.out.println("Probando commit");
            Statement stmt = (Statement) con.createStatement();
            String query;
            String dbUser;
            String dbPass;
            query = "SELECT user, password FROM users;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                dbUser = rs.getString("user");
                dbPass = rs.getString("password");

                if(dbUser.equals(getUser()) && dbPass.equals(getPass())){
                    
                    res=true;
                }
            }
            con.close();
        }
        catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
            
        }
       
        return res;
    }
            
}
