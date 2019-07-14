/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import static com.hilarysturges.softwareii.CustomerRecordsController.testCustomers;
import static com.hilarysturges.softwareii.CustomerRecordsController.testCustomers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AppointmentsController implements Initializable {
    
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
    
    static ObservableList<Appointment> appointments = FXCollections.observableArrayList();
    
    public void editButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editAppointment.fxml"));
        Parent editParent = loader.load();
        Scene editScene = new Scene(editParent);
        EditAppointmentController controller = loader.getController();
        controller.initData(tableViewAppts.getSelectionModel().getSelectedItem());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(editScene);
        window.show();
    }
    
    public void deleteButtonPushed() {
        int appointmentId = 0;

        ObservableList<Appointment> selectedRows, allAppts;
        allAppts = tableViewAppts.getItems();
        selectedRows = tableViewAppts.getSelectionModel().getSelectedItems();
        for (Appointment appt : selectedRows) {
            allAppts.remove(appt);
            appointmentId = appt.getApptID();
        }
        
        try {   
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String delAppt = "delete from appointment where appointmentId=?";
        PreparedStatement prepDel = conn.prepareStatement(delAppt);
        prepDel.setInt(1,appointmentId);
        prepDel.execute();
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
    }
    
    public void addButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addAppointment.fxml"));
        Parent addApptParent = loader.load();
        Scene addApptScene = new Scene(addApptParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addApptScene);
        window.show();
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
    
    public static ObservableList<Appointment> addAppointments() {

        return appointments;
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
        start.setCellValueFactory(new PropertyValueFactory<Appointment, Timestamp>("start"));
        end.setCellValueFactory(new PropertyValueFactory<Appointment, Timestamp>("end"));
        created.setCellValueFactory(new PropertyValueFactory<Appointment, Date>("created"));
        createdBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCreatedBy()));
        updated.setCellValueFactory(new PropertyValueFactory<Appointment, Date>("updated"));
        updatedBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUpdatedBy()));
        title.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewAppts.setItems(addAppointments());
    }    
    
}
