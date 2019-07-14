/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import static com.hilarysturges.softwareii.AppointmentsController.addAppointments;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class ReportsController implements Initializable {
    
    @FXML private TableView<Appointment> tableViewAppts;
    @FXML private TableColumn<Appointment, Integer> apptId;
    @FXML private TableColumn<Appointment, Integer> customerId;
    @FXML private TableColumn<Appointment, Integer> userId;
    @FXML private TableColumn<Appointment, String> title;
    @FXML private TableColumn<Appointment, String> description;
    @FXML private TableColumn<Appointment, String> location;
    @FXML private TableColumn<Appointment, String> contact;
    @FXML private TableColumn<Appointment, String> type;
    @FXML private TableColumn<Appointment, String> url1;
    @FXML private TableColumn<Appointment, Timestamp> start;
    @FXML private TableColumn<Appointment, Timestamp> end;
    @FXML private TableColumn<Appointment, Date> created;
    @FXML private TableColumn<Appointment, String> createdBy;
    @FXML private TableColumn<Appointment, Date> updated;
    @FXML private TableColumn<Appointment, String> updatedBy;
    
    @FXML private ComboBox monthBox;
    @FXML private ComboBox userBox;
    @FXML private ComboBox typeBox;
    
    
    public void monthSelected(ActionEvent event) throws IOException {
        if (monthBox.getValue().equals("January")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.FEBRUARY, 1));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("February")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.MARCH, 1)) && date.isAfter(LocalDate.of(2019, Month.JANUARY, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("March")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.APRIL, 1)) && date.isAfter(LocalDate.of(2019, Month.FEBRUARY, 28));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("April")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.MAY, 1)) && date.isAfter(LocalDate.of(2019, Month.MARCH, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("May")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.JUNE, 1)) && date.isAfter(LocalDate.of(2019, Month.APRIL, 30));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("June")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.JULY, 1)) && date.isAfter(LocalDate.of(2019, Month.MAY, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("July")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.AUGUST, 1)) && date.isAfter(LocalDate.of(2019, Month.JUNE, 30));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("August")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.SEPTEMBER, 1)) && date.isAfter(LocalDate.of(2019, Month.JULY, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("September")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.OCTOBER, 1)) && date.isAfter(LocalDate.of(2019, Month.AUGUST, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("October")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.NOVEMBER, 1)) && date.isAfter(LocalDate.of(2019, Month.SEPTEMBER, 30));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("November")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isBefore(LocalDate.of(2019, Month.DECEMBER, 1)) && date.isAfter(LocalDate.of(2019, Month.OCTOBER, 31));                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (monthBox.getValue().equals("December")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                LocalDate date = LocalDate.parse(String.valueOf(appointment.getStart()).substring(0,10),DateTimeFormatter.ISO_DATE);
                    return date.isAfter(LocalDate.of(2019, Month.NOVEMBER, 30));                
        } ); tableViewAppts.setItems(filteredByMonth);
        }
        
    }
    
    public void userSelected(ActionEvent event) throws IOException {
        if (userBox.getValue().equals("test")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                String user = appointment.getCreatedBy();
                    return user.equals("test");                
        } ); tableViewAppts.setItems(filteredByMonth);
        } if (userBox.getValue().equals("other")) {
            FilteredList<Appointment> filteredByMonth = new FilteredList<>(AppointmentsController.appointments);
            filteredByMonth.setPredicate(appointment -> {
                String user = appointment.getCreatedBy();
                    return user.equals("other");                
        } ); tableViewAppts.setItems(filteredByMonth);
        }
    }
    
    public void typeSelected(ActionEvent event) throws IOException {
        if (typeBox.getValue().equals("Presentation")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Presentation");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Scrum")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Scrum");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Review")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Review");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Standup")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Standup");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("All Hands")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("All Hands");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("One on One")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("One on One");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Retrospective")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Retrospective");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Interview")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Interview");                
        } ); tableViewAppts.setItems(filteredByType);
        } if (typeBox.getValue().equals("Other")) {
            FilteredList<Appointment> filteredByType = new FilteredList<>(AppointmentsController.appointments);
            filteredByType.setPredicate(appointment -> {
                String type = appointment.getType();
                    return type.equals("Other");                
        } ); tableViewAppts.setItems(filteredByType);
        }
    }

    public void returnToMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainscreen.fxml"));
        Parent mainParent = loader.load();
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        apptId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getApptID()).asObject());
        customerId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCustomerID()).asObject());
        userId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getUserID()).asObject());
        title.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTitle()));
        description.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDescription()));
        location.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLocation()));
        contact.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getContact()));
        type.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getType()));
        url1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUrl()));
        start.setCellValueFactory(new PropertyValueFactory<>("start"));
        end.setCellValueFactory(new PropertyValueFactory<>("end"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));
        createdBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCreatedBy()));
        updated.setCellValueFactory(new PropertyValueFactory<Appointment, Date>("updated"));
        updatedBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUpdatedBy()));
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewAppts.setItems(addAppointments());
        
        monthBox.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
        userBox.getItems().addAll("test","other");
        typeBox.getItems().addAll("Presentation","Scrum","Review","Standup","All Hands","One on One", "Retrospective","Interview","Other");
    }    
}
