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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    
    Alert finalAlert = new Alert(Alert.AlertType.INFORMATION);
    String finalMessage = "";
    
    public void returnToCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
    }
    
    public void checkNameField(MouseEvent event) throws IOException {
        if (customerNameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter a customer name");
            alert.showAndWait();
        }
    }
    
    public void checkAddress1Field(MouseEvent event) throws IOException {
        if (address1Field.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter an address line 1");
            alert.showAndWait();
        }
    }
    
    public void checkAddress2Field(MouseEvent event) throws IOException {
        if (address2Field.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter an address line 2");
            alert.showAndWait();
        }
    }
    
    public void checkPostalCodeField(MouseEvent event) throws IOException {
        if (postalCodeField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter a postal code");
            alert.showAndWait();
        }
    }
    
    public void checkPhoneField(MouseEvent event) throws IOException {
        if (phoneField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter a phone number");
            alert.showAndWait();
        }
    }
    
    public void checkCityField(MouseEvent event) throws IOException {
        if (cityField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("You must enter a city");
            alert.showAndWait();
        }
    }
    
    public void checkAllFields() {
        if (customerNameField.getText().isEmpty()) {
            finalMessage+="You must enter a customer name \n";            
        } if (address1Field.getText().isEmpty()) {
            finalMessage+="You must enter an address line 1 \n";
        } if (address2Field.getText().isEmpty()) {
            finalMessage+="You must enter an address line 2 \n";
        } if (postalCodeField.getText().isEmpty()) {
            finalMessage+="You must enter a postal code \n";
        } if (phoneField.getText().isEmpty()) {
            finalMessage+="You must enter a phone number \n";
        } if (cityField.getText().isEmpty()) {
            finalMessage+="You must enter a city \n";
        }
    }
    
    public void addButtonPushed(ActionEvent event) throws IOException {
        checkAllFields();
        if (customerNameField.getText().isEmpty() || address1Field.getText().isEmpty() ||
                address2Field.getText().isEmpty() || postalCodeField.getText().isEmpty() ||
                phoneField.getText().isEmpty() || cityField.getText().isEmpty()) {
            finalAlert.setTitle("Missing information");
            finalAlert.setHeaderText("You must complete the form");
            finalAlert.setContentText(finalMessage);
            finalAlert.showAndWait();
            System.out.println(finalMessage);
            finalMessage = "";
        } else {
        //add to database
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
        prepAdd.setInt(3,cityId);
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
        CustomerRecordsController.testCustomers.add(new Customer(customerId,customerNameField.getText(),address1Field.getText(),address2Field.getText(),postalCodeField.getText(),phoneField.getText(),cityField.getText(),addressId,activeBoolean,startDate,"test",startDate,"test")); 
        
        //return to customer screen
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent customerParent = loader.load();
        Scene customerScene = new Scene(customerParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(customerScene);
        window.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
