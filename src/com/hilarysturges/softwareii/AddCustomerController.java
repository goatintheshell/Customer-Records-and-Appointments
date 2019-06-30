/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class AddCustomerController implements Initializable {

    @FXML private TextField customerNameField;
    @FXML private TextField address1Field;
    @FXML private TextField address2Field;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;
    @FXML private TextField cityField;
    @FXML private CheckBox activeCheckBox;
    
    public void returnToCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
    }
    
    public void addButtonPushed(ActionEvent event) throws IOException {
        //add to database
        int customerId = 0;
        int addressId = 0;
        int activeBoolean = 0;
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        try {
            
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String addAddress = "insert into address (address,address2,cityId,postalCode,phone,createDate,createdBy,lastUpdate,lastUpdateBy)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepAdd = conn.prepareStatement(addAddress);
        prepAdd.setString(1,address1Field.getText());
        prepAdd.setString(2,address2Field.getText());
        prepAdd.setInt(3,1);
        prepAdd.setString(4,postalCodeField.getText());
        prepAdd.setString(5,phoneField.getText());
        prepAdd.setDate(6,startDate);
        prepAdd.setString(7,"test");
        prepAdd.setDate(8,startDate);
        prepAdd.setString(9,"test");
        prepAdd.execute();
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
        
        try {            
            
        
        if (activeCheckBox.isSelected()) {
            activeBoolean = 1;
        }
        
        
            
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String addCustomer = "insert into customer (customerName,addressId,active,createDate,createdBy,lastUpdate,lastUpdateBy)"
                + "VALUES (?,?,?,?,?,?,?);";
        //get address ID
        
        String checkAddressId = "select addressId from address order by addressId desc limit 1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(checkAddressId);
        while (rs.next()) {
            addressId=rs.getInt("addressId");
        }
        //prep and execute insert statement
        PreparedStatement prepAdd = conn.prepareStatement(addCustomer);
        prepAdd.setString(1,customerNameField.getText());
        //assign address ID
        prepAdd.setInt(2,addressId);
        //if checked, this will be 1, unchecked 0
        prepAdd.setInt(3,activeBoolean);
        prepAdd.setDate(4,startDate);
        prepAdd.setString(5,"test");
        prepAdd.setDate(6,startDate);
        prepAdd.setString(7,"test");
        prepAdd.execute();
        
        String checkCustomerId = "select customerId from customer order by customerId desc limit 1";
        Statement state = conn.createStatement();
        ResultSet rset = state.executeQuery(checkCustomerId);
        while (rset.next()) {
            customerId=rset.getInt("customerId"); }
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
         
        //add to class
        CustomerRecordsController.testCustomers.add(new Customer(customerId,customerNameField.getText(),address1Field.getText(),addressId,activeBoolean,startDate,"test",startDate,"test")); 
        
        //return to customer screen
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
