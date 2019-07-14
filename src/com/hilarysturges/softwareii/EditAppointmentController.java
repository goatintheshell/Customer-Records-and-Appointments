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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class EditAppointmentController implements Initializable {

    @FXML private TextField customerIdField;
    @FXML private TextField titleField;
    @FXML private TextField descField;
    @FXML private TextField locField;
    @FXML private TextField contactField;
    @FXML private TextField typeField;
    @FXML private TextField urlField;
    @FXML private DatePicker datePicker;
    @FXML private TextField startField;
    @FXML private TextField endField;
    private Appointment selectedAppt;
    
    public void editButtonPushed(ActionEvent event) throws IOException {
        //update database      
        Timestamp startTime = Timestamp.valueOf(datePicker.getValue() + " " + startField.getText());
        Timestamp endTime = Timestamp.valueOf(datePicker.getValue() + " " + endField.getText());
        try {   
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String addAddress = "update appointment set customerId=?, title=?, description=?, location=?, contact=?, type=?, url=?, start=?, end=?, lastUpdate=curDate()" 
                + "where appointmentId=?";
        PreparedStatement prepAdd = conn.prepareStatement(addAddress);
        prepAdd.setInt(1,Integer.parseInt(customerIdField.getText()));
        prepAdd.setString(2,titleField.getText());
        prepAdd.setString(3,descField.getText());
        prepAdd.setString(4,locField.getText());
        prepAdd.setString(5,contactField.getText());
        prepAdd.setString(6,typeField.getText());
        prepAdd.setString(7,urlField.getText());
        prepAdd.setTimestamp(8,startTime);
        prepAdd.setTimestamp(9,endTime);
        prepAdd.setInt(10,selectedAppt.getApptID());
        prepAdd.execute();        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
         
        //update class
        Calendar calendar = Calendar.getInstance();
        java.sql.Date currDate = new java.sql.Date(calendar.getTime().getTime());
        selectedAppt.setCustomerID(Integer.parseInt(customerIdField.getText()));
        selectedAppt.setTitle(titleField.getText());
        selectedAppt.setDescription(descField.getText());
        selectedAppt.setLocation(locField.getText());
        selectedAppt.setContact(contactField.getText());
        selectedAppt.setType(typeField.getText());
        selectedAppt.setUrl(urlField.getText());
        selectedAppt.setStart(startTime);
        selectedAppt.setEnd(endTime);
        selectedAppt.setUpdated(currDate);
        
        //return to customer screen
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("appointments.fxml"));
        Parent apptParent = loader.load();
        Scene apptScene = new Scene(apptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(apptScene);
        window.show();
    }
    
    public void initData(Appointment appt) {
        selectedAppt = appt;
        customerIdField.setText(String.valueOf(selectedAppt.getCustomerID()));
        titleField.setText(selectedAppt.getTitle());
        descField.setText(selectedAppt.getDescription());
        locField.setText(selectedAppt.getLocation());
        contactField.setText(selectedAppt.getContact());
        typeField.setText(selectedAppt.getType());
        urlField.setText(selectedAppt.getUrl());
        datePicker.setValue(LocalDate.parse(selectedAppt.getStart().toString().substring(0, 10)));
        startField.setText(String.valueOf(selectedAppt.getStart()).substring(11, 19));
        endField.setText(String.valueOf(selectedAppt.getEnd()).substring(11, 19));
    }
    
    public void returnToAppointment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("appointments.fxml"));
        Parent apptParent = loader.load();
        Scene apptScene = new Scene(apptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(apptScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
