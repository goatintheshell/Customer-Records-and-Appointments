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
import java.util.regex.Pattern;
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
import javafx.scene.input.MouseEvent;
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
    
    Alert finalAlert = new Alert(Alert.AlertType.INFORMATION);
    String finalMessage = "";
    
    public boolean checkOverlapping() {
        boolean answer = false;
        if (datePicker.getValue() != null) {
        Timestamp newApptStart = Timestamp.valueOf(datePicker.getValue() + " " + startField.getText());
        Timestamp newApptEnd = Timestamp.valueOf(datePicker.getValue() + " " + endField.getText());
        Timestamp oldApptStart;
        Timestamp oldApptEnd;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Overlapping appointments");
              alert.setHeaderText("Appointment already scheduled for this time");
              alert.setContentText("Please alter appointment time");
        for (int i=0 ; i<AppointmentsController.appointments.size() ; i++) {
            oldApptStart = AppointmentsController.appointments.get(i).getStart();
            oldApptEnd = AppointmentsController.appointments.get(i).getEnd();
            if (newApptStart.before(oldApptEnd) && newApptStart.after(oldApptStart)) {
                alert.showAndWait();
                answer = true;
                }
            if (newApptEnd.after(oldApptStart) && newApptEnd.before(oldApptEnd)) {
                alert.showAndWait();
                answer = true;
            }
            }
        }
        return answer;
    }
    
    public void checkIdMouse(MouseEvent event) throws IOException {
        checkIdIsInt();
    }
    
    public boolean checkIdIsInt() {
        boolean answer = Pattern.matches("[abcdefghijklmnopqrstuvwxyz]",customerIdField.getText());
        if (answer == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Customer ID");
            alert.setHeaderText("Invalid Customer ID");
            alert.setContentText("Customer ID must be a number");
            alert.showAndWait();
        }
        return answer;
    }
    
    public void checkStartMouse(MouseEvent event) throws IOException {
        checkStartBusinessHours();
        checkOverlapping();
    }
    
    public boolean checkStartBusinessHours() {
        boolean answer = false;
        if (startField.getText().isEmpty() == false) {
        Timestamp startTime = Timestamp.valueOf("2019-07-14 " + startField.getText());
        Timestamp fiveOClock = Timestamp.valueOf("2019-07-14 17:00:00");
        Timestamp EightOClock = Timestamp.valueOf("2019-07-14 08:00:00");
        if (startTime.after(fiveOClock)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Outside Business Hours");
            alert.setHeaderText("Outside Business Hours");
            alert.setContentText("Start time is after 5PM");
            alert.showAndWait();
            answer = true;
            }
        if (startTime.before(EightOClock)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Outside Business Hours");
            alert.setHeaderText("Outside Business Hours");
            alert.setContentText("Start time is before 8AM");
            alert.showAndWait();
            answer = true;
        }
        } else {
            Alert emptyAlert = new Alert(Alert.AlertType.INFORMATION);
            emptyAlert.setTitle("Missing information");
            emptyAlert.setHeaderText("Start time is missing");
            emptyAlert.setContentText("Please enter a start time");
            emptyAlert.showAndWait();
        }
        return answer;
    }
    
    public void checkEndMouse(MouseEvent event) throws IOException {
        checkEndBusinessHours();
        checkOverlapping();
    }
    
    public boolean checkEndBusinessHours() {
        boolean answer = false;
        if (endField.getText().isEmpty() == false) {
        Timestamp endTime = Timestamp.valueOf("2019-07-14 " + endField.getText());
        Timestamp fiveOClock = Timestamp.valueOf("2019-07-14 17:00:00");
        Timestamp EightOClock = Timestamp.valueOf("2019-07-14 08:00:00");
        if (endTime.after(fiveOClock)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Outside Business Hours");
            alert.setHeaderText("Outside Business Hours");
            alert.setContentText("End time is after 5PM");
            alert.showAndWait();
            answer = true;
            }
        if (endTime.before(EightOClock)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Outside Business Hours");
            alert.setHeaderText("Outside Business Hours");
            alert.setContentText("End time is before 8AM");
            alert.showAndWait();
            answer = true;
        }
        } else {
            Alert emptyAlert = new Alert(Alert.AlertType.INFORMATION);
            emptyAlert.setTitle("Missing information");
            emptyAlert.setHeaderText("End time is missing");
            emptyAlert.setContentText("Please enter an end time");
            emptyAlert.showAndWait();
        }
        return answer;
    }
    
    public void checkAllFields() {
        if (customerIdField.getText().isEmpty()) {
            finalMessage+="You must enter a customer ID number \n";            
        } if (titleField.getText().isEmpty()) {
            finalMessage+="You must enter a title \n";
        } if (descField.getText().isEmpty()) {
            finalMessage+="You must enter a description \n";
        } if (typeField.getText().isEmpty()) {
            finalMessage+="You must enter a meeting type \n";
        } if (contactField.getText().isEmpty()) {
            finalMessage+="You must enter an employee contact \n";
        } if (urlField.getText().isEmpty()) {
            finalMessage+="You must enter a meeting URL \n";
        } if (locField.getText().isEmpty()) {
            finalMessage+="You must enter a meeting location \n";
        } if (startField.getText().isEmpty()) {
            finalMessage+="You must enter a start time \n";
        } if (endField.getText().isEmpty()) {
            finalMessage+="You must enter an end time \n";
        } if (datePicker.getValue() == null) {
            finalMessage+="You must select a date \n";
        } if (checkStartBusinessHours() == true) {
            finalMessage+="Start time must be within business hours \n";
        } if (checkEndBusinessHours() == true) {
            finalMessage+="End time must be within business hours \n";
        } if (checkOverlapping() == true) {
            finalMessage+="Overlapping appointments, please change time \n";
        } if (checkIdIsInt() == true) {
            finalMessage+="Customer ID must be a number \n";
        }
    }
    
    public void editButtonPushed(ActionEvent event) throws IOException {
        checkAllFields();
        if (customerIdField.getText().isEmpty() || titleField.getText().isEmpty() ||
                descField.getText().isEmpty() || typeField.getText().isEmpty() ||
                contactField.getText().isEmpty() || urlField.getText().isEmpty() ||
                locField.getText().isEmpty() || startField.getText().isEmpty() ||
                endField.getText().isEmpty() || datePicker.getValue() == null ||
                checkIdIsInt() == true || checkStartBusinessHours() == true ||
                checkEndBusinessHours() == true || checkOverlapping() == true) {
            finalAlert.setTitle("Missing or incorrect information");
            finalAlert.setHeaderText("You must complete the form");
            finalAlert.setContentText(finalMessage);
            finalAlert.showAndWait();
            finalMessage = "";
        } else {
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
