/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MINUTE;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class MainscreenController implements Initializable {
    
    static int counter;
    
    public static void writeOutLogins(User user) {
        Calendar calendar = Calendar.getInstance();
        Timestamp curTime = new Timestamp(calendar.getTime().getTime());
        try {
            FileWriter file = new FileWriter("logins.txt",true);
            file.append(System.getProperty("line.separator"));
            file.write(user.getUsername() + " logged in on " + curTime);
            file.close();
        } catch (Exception e) {
            System.out.println("Error writing file");
        }
    }
    
    public static void meetingAlert() {
            FilteredList<Appointment> filteredByTime = new FilteredList<>(AppointmentsController.appointments);
            filteredByTime.setPredicate(appointment -> {
                Timestamp time = appointment.getStart();
                Calendar calendar = Calendar.getInstance();
                Timestamp curTime  = new Timestamp(calendar.getTime().getTime());
                long t=curTime.getTime();
                long p=15*60*1000;
                long m=60*1000;
                Timestamp timePlus15 = new Timestamp(t+p);
                Timestamp timeMinus1 = new Timestamp(t-m);
               
                    return time.before(timePlus15) && time.after(timeMinus1);                
        } ); //trigger alert
            System.out.println(filteredByTime);
            if (filteredByTime.isEmpty() == false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Meeting soon");
            alert.setHeaderText("You have a meeting in the next 15 minutes");
            alert.setContentText(filteredByTime.get(0).getTitle());
            alert.showAndWait();
            }
    }
    
    public void logOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent loginParent = loader.load();
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
    
    public void viewCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerRecords.fxml"));
        Parent custParent = loader.load();
        Scene custScene = new Scene(custParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(custScene);
        window.show();
    }
    
    public void viewAppt(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("appointments.fxml"));
        Parent apptParent = loader.load();
        Scene apptScene = new Scene(apptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(apptScene);
        window.show();
    }
    
    public void viewCalendar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendarMonth.fxml"));
        Parent calMonParent = loader.load();
        Scene calMonScene = new Scene(calMonParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(calMonScene);
        window.show();
    }
    
    public void viewReport(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("reports.fxml"));
        Parent reportParent = loader.load();
        Scene reportScene = new Scene(reportParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(reportScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (counter == 0) {
            try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String query = "select c.customerId, c.customerName, a.address, a.address2, a.postalCode, a.phone, city.city, c.addressId, c.active, c.createDate, c.createdBy, c.lastUpdate, c.lastUpdateBy "
                +       "from customer c join address a on c.addressID = a.addressID join city on a.cityId = city.cityId;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            //System.out.println("In while loop");
            int ID = rs.getInt("customerId");
            String name = rs.getString("customerName");
            String address = rs.getString("address");
            String address2 = rs.getString("address2");
            String postalCode = rs.getString("postalCode");
            String phone = rs.getString("phone");
            String city = rs.getString("city");
            int addressId = rs.getInt("addressId");
            int active = rs.getInt("active");
            Date created = rs.getDate("createDate");
            String createdBy = rs.getString("createdBy");
            Date updated = rs.getDate("lastUpdate");
            String updatedBy = rs.getString("lastUpdateBy");
            
            CustomerRecordsController.testCustomers.add(new Customer(ID,name,address,address2,postalCode,phone,city,addressId,active,created,createdBy,updated,updatedBy)); 
        }
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String query = "select * from appointment";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            //System.out.println("In while loop");
            int ID = rs.getInt("appointmentId");
            int customer = rs.getInt("customerId");
            int user = rs.getInt("userId");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String location = rs.getString("location");
            String contact = rs.getString("contact");
            String type = rs.getString("type");
            String url1 = rs.getString("url");
            Timestamp start = rs.getTimestamp("start");
            Timestamp end = rs.getTimestamp("end");
            Date created = rs.getDate("createDate");
            String createdBy = rs.getString("createdBy");
            Date updated = rs.getDate("lastUpdate");
            String updatedBy = rs.getString("lastUpdateBy");
            
            AppointmentsController.appointments.add(new Appointment(ID,customer,user,title,description,location,contact,type,url1,start,end,created,createdBy,updated,updatedBy)); 
        }
            
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }  counter++; //System.out.println(counter);
      }    
    }
}
