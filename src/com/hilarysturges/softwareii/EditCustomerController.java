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
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class EditCustomerController implements Initializable {

    @FXML private TextField customerNameField;
    @FXML private TextField address1Field;
    @FXML private TextField address2Field;
    @FXML private TextField postalCodeField;
    @FXML private TextField phoneField;
    @FXML private TextField cityField;
    @FXML private CheckBox activeCheckBox;
    private Customer selectedCustomer;
    
    public void saveButtonPushed(ActionEvent event) throws IOException {
        //update database
        int cityId = 1;
            if (cityField.getText().equalsIgnoreCase("Los Angeles")) {
                cityId = 2;
            } if (cityField.getText().equalsIgnoreCase("Toronto")) {
                cityId = 3;
            } if (cityField.getText().equalsIgnoreCase("Vancouver")) {
                cityId = 4;
            } if (cityField.getText().equalsIgnoreCase("Oslo")) {
                cityId = 5;
            }
        int activeBoolean = 0;
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String updateAddress = "update address set address=?, address2=?,cityId=?,postalCode=?,phone=?,lastUpdate=curDate() "
                +               "where addressId=?";
        PreparedStatement prepAdd = conn.prepareStatement(updateAddress);
        prepAdd.setString(1,address1Field.getText());
        prepAdd.setString(2,address2Field.getText());
        prepAdd.setInt(3,cityId);
        prepAdd.setString(4,postalCodeField.getText());
        prepAdd.setString(5,phoneField.getText());
        prepAdd.setInt(6,selectedCustomer.getAddressId());
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
        String updateCustomer = "update customer set customerName=?,active=?,lastUpdate=curDate()"
                + "where customerId=?;";
        //prep and execute insert statement
        PreparedStatement prepAdd = conn.prepareStatement(updateCustomer);
        prepAdd.setString(1,customerNameField.getText());
        prepAdd.setInt(2,activeBoolean);
        prepAdd.setInt(3,selectedCustomer.getCustomerID());
        prepAdd.execute();
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
        
        
        //update instance of class
        Calendar calendar = Calendar.getInstance();
        java.sql.Date updatedDate = new java.sql.Date(calendar.getTime().getTime());
        selectedCustomer.setCustomerName(customerNameField.getText());
        selectedCustomer.setAddress(address1Field.getText());
        selectedCustomer.setAddress2(address2Field.getText());
        selectedCustomer.setPostalCode(postalCodeField.getText());
        selectedCustomer.setPhone(phoneField.getText());
        selectedCustomer.setCity(cityField.getText());
        selectedCustomer.setActive(activeBoolean);
        selectedCustomer.setUpdated(updatedDate);
                
        //return to customer screen
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
    }
    
    public void returnToCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
    }
    
    public void initData(Customer customer) {
        selectedCustomer = customer;
        customerNameField.setText(selectedCustomer.getCustomerName());
        address1Field.setText(selectedCustomer.getAddress());
        address2Field.setText(selectedCustomer.getAddress2());
        postalCodeField.setText(selectedCustomer.getPostalCode());
        phoneField.setText(selectedCustomer.getPhone());
        cityField.setText(selectedCustomer.getCity());
        
        if (selectedCustomer.getActive() == 1) {
        activeCheckBox.setSelected(true);
        } else {
            activeCheckBox.setSelected(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
