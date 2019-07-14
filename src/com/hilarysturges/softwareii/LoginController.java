/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class LoginController implements Initializable {

    
    //User test = new User();
    
    @FXML private Label pleaseLoginLabel;
    @FXML private TextField username;
    @FXML private Label usernameLabel;
    @FXML private TextField password;
    @FXML private Label passwordLabel;
    @FXML private Button loginButton;
    
    User test;
    
    ResourceBundle rb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        rb= ResourceBundle.getBundle("language_files/rb");
        //System.out.println(Locale.getDefault());
        
        pleaseLoginLabel.setText(rb.getString("please"));
        usernameLabel.setText(rb.getString("username"));
        passwordLabel.setText(rb.getString("password"));
        loginButton.setText(rb.getString("login"));
        
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
            LocalDateTime dt = LocalDateTime.now();
            ZoneId zone = ZoneId.of(String.valueOf(TimeZone.getDefault().getID()));
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            String localTimezone = String.format("%1s", offset);
            String timezone = "set time_zone =?";
            PreparedStatement prepAdd = conn.prepareStatement(timezone);
            prepAdd.setString(1,localTimezone);
            prepAdd.execute();
        } catch (Exception e) {
            System.out.println("Problem with timezone");
            System.err.println(e.getMessage());
        }
        
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        
        String query = "SELECT * FROM user";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String username1 = rs.getString("userName");
            String password1 = rs.getString("password");
            
            User test1 = new User(Locale.getDefault().toString(),username1,password1);
            System.out.print(test1 + "\n");
            System.out.format("%s, %s\n",username1, password1); 
            
            createTestUser(test1);
        }
            
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
    }    
    
    public void createTestUser(User test) {
      this.test=test;  
    };
    
    public void login(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainscreen.fxml"));
        Parent mainScreen = loader.load();
        Scene mainScene = new Scene(mainScreen);
        
        //checks username and password
        if (test.getUsername().equals(username.getText().toLowerCase()) && test.getPassword().equals(password.getText().toLowerCase())) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(mainScene);
            window.show();
            MainscreenController.meetingAlert();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            //alert.initModality(Modality.NONE);
            alert.setTitle(rb.getString("incorrect"));
            alert.setHeaderText(rb.getString("incorrect"));
            alert.setContentText(rb.getString("tryagain"));
            alert.showAndWait();
        }
        
        
    }
    
}
