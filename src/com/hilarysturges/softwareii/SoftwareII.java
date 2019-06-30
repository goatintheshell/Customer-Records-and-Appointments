/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.DriverManager;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hilary
 */
public class SoftwareII extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Locale.setDefault(new Locale("es", "ES"));
        System.out.println("Your current region: " + Locale.getDefault());
        ResourceBundle rb = ResourceBundle.getBundle("language_files/rb");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        loader.setResources(rb);
        
        Parent main = null;
        main = loader.load();
        
        Scene scene = new Scene(main);
        
        stage.setScene(scene);
        stage.setTitle("Records and Appointments");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        //
        Connection conn = null;

           String driver   = "com.mysql.cj.jdbc.Driver";         
           String db       = "U05xaQ";         
           String url      = "jdbc:mysql://52.206.157.109:3306/" + db;         
           String user     = "U05xaQ";         
           String pass     = "53688636138";           

try {            
 Class.forName(driver);            
 conn = DriverManager.getConnection(url,user,pass);            
 System.out.println("Connected to database : " + db); 
        } catch (SQLException e) {            
 System.out.println("SQLException: "+e.getMessage());            
 System.out.println("SQLState: "+e.getSQLState());            
 System.out.println("VendorError: "+e.getErrorCode());
         }

            launch(args);
        
       }
    
//    public void setUser() throws Exception {
//        Connection conn = null;
//        try {
//        String query = "SELECT * FROM user";
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            String username = rs.getString("userName");
//            String password = rs.getString("password");
//            
//            User test = new User(Locale.getDefault().toString(),rs.getString("username"),rs.getString("password"));
//            System.out.print(test + "\n");
//            System.out.format("%s, %s\n",username, password); 
//            
//            FXMLLoader loader = new FXMLLoader();
//            LoginController controller = loader.getController();
//            controller.createTestUser(test);
//        }
//            
//         } catch (Exception e) {
//             System.out.println("You done goofed.");
//             System.err.println(e.getMessage());
//         }
//    }
    }
    

