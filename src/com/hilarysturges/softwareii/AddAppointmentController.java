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
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    
    Alert finalAlert = new Alert(Alert.AlertType.INFORMATION);
    String finalMessage = "";

    public void returnToAppointment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("appointments.fxml"));
        Parent apptParent = loader.load();
        Scene apptScene = new Scene(apptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(apptScene);
        window.show();
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
    
    public void addButtonPushed(ActionEvent event) throws IOException {
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
        prepAdd.setTimestamp(9,startTime);
        prepAdd.setTimestamp(10,endTime);
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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
