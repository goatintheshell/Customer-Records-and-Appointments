/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hilary
 */
public class CalendarMonthController implements Initializable {
    
    @FXML private ComboBox monthSelector;
    @FXML private GridPane calendar;
    @FXML private Label[] dateList = new Label[35];
    @FXML private Label[] titleList = new Label[99];
    @FXML private Label[] timeList = new Label[99];

    
    public void monthSelected(ActionEvent event) throws IOException {
        Node[] node = new Node[42];
        for (int i = 0 ; i < 42 ; i++) {
            node[i] = calendar.getChildren().get(i);
        }   calendar.getChildren().clear();
        for (int i=0 ; i < 42 ; i++) {
            calendar.getChildren().add(0,node[i]);
        }
        //sets up January calendar
        if (this.monthSelector.getValue().equals("January")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<7) {
                    GridPane.setConstraints(dateList[i],i,2);
                } if (i>=7 && i<14) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=14 && i<21) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=21 && i<28) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=28 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }   
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Jan")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
            }
        //Sets up February calendar
        if (this.monthSelector.getValue().equals("February")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<29 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<4) {
                    GridPane.setConstraints(dateList[i],i+3,2);
                } if (i>=4 && i<11) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=11 && i<18) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=18 && i<25) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=25 && i<29) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }   
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Feb")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<29 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up March calendar
        if (this.monthSelector.getValue().equals("March")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<4) {
                    GridPane.setConstraints(dateList[i],i+3,2);
                } if (i>=4 && i<11) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=11 && i<18) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=18 && i<25) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=25 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Mar")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up April calendar
        if (this.monthSelector.getValue().equals("April")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=0; i<30 ; i++) {
                dateList[i] = new Label(Integer.toString(i+1));
                if (i<7) {
                    GridPane.setConstraints(dateList[i],i,2);
                } if (i>=7 && i<14) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=14 && i<21) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=21 && i<28) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=28 && i<30) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Apr")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<31 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up May calendar
        if (this.monthSelector.getValue().equals("May")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<6) {
                    GridPane.setConstraints(dateList[i],i+1,2);
                } if (i>=6 && i<13) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=13 && i<20) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=20 && i<27) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=27 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("May")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up June calendar
        if (this.monthSelector.getValue().equals("June")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<31 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<3) {
                    GridPane.setConstraints(dateList[i],i+4,2);
                } if (i>=3 && i<10) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=10 && i<17) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=17 && i<24) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=24 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Jun")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<31 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up July calendar
        if (this.monthSelector.getValue().equals("July")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=0; i<31 ; i++) {
                dateList[i] = new Label(Integer.toString(i+1));
                if (i<7) {
                    GridPane.setConstraints(dateList[i],i,2);
                } if (i>=7 && i<14) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=14 && i<21) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=21 && i<28) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=28 && i<31) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }   
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Jul")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //Sets up August calendar
        if (this.monthSelector.getValue().equals("August")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<5) {
                    GridPane.setConstraints(dateList[i],i+2,2);
                } if (i>=5 && i<12) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=12 && i<19) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=19 && i<26) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=26 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Aug")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up September calendar
        if (this.monthSelector.getValue().equals("September")) {
            int j=0; int k=0; int l=0; int m=1;
            for (int i=1; i<31 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<2) {
                    GridPane.setConstraints(dateList[i],i+5,2);
                } if (i>=2 && i<9) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=9 && i<16) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=16 && i<23) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=24 && i<30) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                } if (i==30) {
                    GridPane.setConstraints(dateList[23],0,6);
                    GridPane.setValignment(dateList[23], VPos.TOP);
                    GridPane.setConstraints(dateList[30],0,6);
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Sep")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<31 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up October calendar
        if (this.monthSelector.getValue().equals("October")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<7) {
                    GridPane.setConstraints(dateList[i],i,2);
                } if (i>=7 && i<14) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=14 && i<21) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=21 && i<28) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=28 && i<32) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Oct")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up November calendar
        if (this.monthSelector.getValue().equals("November")) {
            int j=0; int k=0; int l=0; int m=0;
            for (int i=1; i<31 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<4) {
                    GridPane.setConstraints(dateList[i],i+3,2);
                } if (i>=4 && i<11) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=11 && i<18) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=18 && i<25) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                } if (i>=25 && i<31) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Nov")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<31 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
        }
        //sets up December calendar
        if (this.monthSelector.getValue().equals("December")) {
            int j=0; int k=0; int l=0; int m=2;
            for (int i=1; i<32 ; i++) {
                dateList[i] = new Label(Integer.toString(i));
                if (i<2) {
                    GridPane.setConstraints(dateList[i],i+5,2);
                } if (i>=2 && i<9) {
                    GridPane.setConstraints(dateList[i],j,3);
                    j++;
                } if (i>=9 && i<16) {
                    GridPane.setConstraints(dateList[i],k,4);
                    k++;
                } if (i>=16 && i<23) {
                    GridPane.setConstraints(dateList[i],l,5);
                    l++;
                }  if (i>=25 && i<30) {
                    GridPane.setConstraints(dateList[i],m,6);
                    m++;
                } if (i==30) {
                  GridPane.setConstraints(dateList[23],0,6);
                  GridPane.setValignment(dateList[23], VPos.TOP);
                  GridPane.setConstraints(dateList[30],0,6);
                } if (i==31) {
                  GridPane.setConstraints(dateList[24],1,6);
                  GridPane.setValignment(dateList[24], VPos.TOP);
                  GridPane.setConstraints(dateList[31],1,6);  
                }
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
            }  
                int limit = AppointmentsController.appointments.size();
                String month;
                for (int o=0 ; o<limit ; o++) {
                    month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(o).getStart());
                    if (month.equals("Dec")) {
                        for (int i=0 ; i<limit ; i++) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(o).getStart());
                            String day = new SimpleDateFormat("d").format(AppointmentsController.appointments.get(o).getStart());
                            titleList[i] = new Label(AppointmentsController.appointments.get(o).getTitle());
                            timeList[i] = new Label(time);
                            calendar.getChildren().add(titleList[i]);
                            calendar.getChildren().add(timeList[i]);
                            GridPane.setValignment(titleList[i], VPos.TOP);
                    int columnIndex;
                    int rowIndex;
                        for (int n=1 ; n<32 ; n++) {
                            if (day.equals(dateList[n].getText())) {
                                columnIndex = GridPane.getColumnIndex(dateList[n]);
                                rowIndex = GridPane.getRowIndex(dateList[n]);
                                GridPane.setConstraints(titleList[i],columnIndex,rowIndex);
                                GridPane.setConstraints(timeList[i],columnIndex,rowIndex);
                                }
                            } 
                        }
                    }
                }
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
    
    public void viewByWeek(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendarWeek.fxml"));
        Parent calWeekParent = loader.load();
        Scene calWeekScene = new Scene(calWeekParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(calWeekScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthSelector.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December");
        
    }    
    
}
