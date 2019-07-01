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
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class AddAppointmentController implements Initializable {
    
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

    public void returnToAppointment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("appointments.fxml"));
        Parent apptParent = loader.load();
        Scene apptScene = new Scene(apptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(apptScene);
        window.show();
    }
    
    public void addButtonPushed(ActionEvent event) throws IOException {
        //add to database      
        int appointmentId = 0;
        Timestamp startTime = Timestamp.valueOf(datePicker.getValue() + " " + startField.getText());
        Timestamp endTime = Timestamp.valueOf(datePicker.getValue() + " " + endField.getText());
        
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Timestamp curTime = new java.sql.Timestamp(calendar.getTime().getTime());
        
        try {
            
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String addAddress = "insert into appointment (customerId,userId,title,description,location,contact,type,url,start,end,createDate,createdBy,lastUpdate,lastUpdateBy) \n" 
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prepAdd = conn.prepareStatement(addAddress);
        prepAdd.setInt(1,Integer.parseInt(customerIdField.getText()));
        prepAdd.setInt(2,1);
        prepAdd.setString(3,titleField.getText());
        prepAdd.setString(4,descField.getText());
        prepAdd.setString(5,locField.getText());
        prepAdd.setString(6,contactField.getText());
        prepAdd.setString(7,typeField.getText());
        prepAdd.setString(8,urlField.getText());
        prepAdd.setDate(9,startDate);
        prepAdd.setDate(10,startDate);
        prepAdd.setDate(11,startDate);
        prepAdd.setString(12,"test");
        prepAdd.setDate(13,startDate);
        prepAdd.setString(14,"test");
        prepAdd.execute();
        
        String checkAppointmentId = "select appointmentId from appointment order by appointmentId desc limit 1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(checkAppointmentId);
        while (rs.next()) {
            appointmentId=rs.getInt("appointmentId");
        }
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
         
        //add to class
        AppointmentsController.appointments.add(new Appointment(appointmentId,Integer.parseInt(customerIdField.getText()),1,titleField.getText(),descField.getText(),locField.getText(),contactField.getText(),typeField.getText(),urlField.getText(),startTime,endTime,startDate,"test",startDate,"test")); 
        
        //return to customer screen
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
