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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class CustomerRecordsController implements Initializable {

    @FXML private TableView<Customer> tableViewCustomers;
    @FXML private TableColumn<Customer, Integer> id;
    @FXML private TableColumn<Customer, String> name;
    @FXML private TableColumn<Customer, String> address;
    @FXML private TableColumn<Customer, Integer> active;
    @FXML private TableColumn<Customer, Date> created;
    @FXML private TableColumn<Customer, String> createdBy;
    @FXML private TableColumn<Customer, Date> lastUpdated;
    @FXML private TableColumn<Customer, String> updatedBy;
    
    static ObservableList<Customer> testCustomers = FXCollections.observableArrayList();
    
    public void editButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editCustomer.fxml"));
        Parent editParent = loader.load();
        Scene editScene = new Scene(editParent);
        EditCustomerController controller = loader.getController();
        controller.initData(tableViewCustomers.getSelectionModel().getSelectedItem());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(editScene);
        window.show();
    }
    
    public void deleteButtonPushed() {
        int customerId = 0;
        int addressId = 0;
        
        ObservableList<Customer> selectedRows, allCustomers;
        allCustomers = tableViewCustomers.getItems();
        selectedRows = tableViewCustomers.getSelectionModel().getSelectedItems();
        for (Customer cust : selectedRows) {
            allCustomers.remove(cust);
            customerId = cust.getCustomerID();
            addressId = cust.getAddressId();
        }
        
        try {   
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String delCustomer = "delete from customer where customerId=?";
        PreparedStatement prepDel = conn.prepareStatement(delCustomer);
        prepDel.setInt(1,customerId);
        prepDel.execute();
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
        
        try {   
        Connection conn = DriverManager.getConnection("jdbc:mysql://52.206.157.109:3306/U05xaQ", "U05xaQ", "53688636138");
        String delAddress = "delete from address where addressId=?";
        PreparedStatement prepDel = conn.prepareStatement(delAddress);
        prepDel.setInt(1,addressId);
        prepDel.execute();
        
         } catch (Exception e) {
             System.out.println("You done goofed.");
             System.err.println(e.getMessage());
         }
    }
    
    public void addButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addCustomer.fxml"));
        Parent addCustParent = loader.load();
        Scene addCustScene = new Scene(addCustParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(addCustScene);
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
    
    public static ObservableList<Customer> testCustomers(){
        return testCustomers;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCustomerID()).asObject());
        name.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCustomerName()));
        address.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAddress()));
        active.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getActive()).asObject());
        created.setCellValueFactory(new PropertyValueFactory<>("created"));
        createdBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCreatedBy()));
        lastUpdated.setCellValueFactory(new PropertyValueFactory<>("updated"));
        updatedBy.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUpdatedBy()));
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        tableViewCustomers.setItems(testCustomers());
        
        
    }    
    
}
