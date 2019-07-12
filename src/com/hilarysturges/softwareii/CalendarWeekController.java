/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilarysturges.softwareii;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
public class CalendarWeekController implements Initializable {
    
    @FXML private ComboBox weekSelector;
    @FXML private GridPane calendar;
    @FXML private Label[] dateList = new Label[7];
    @FXML private Label[] titleList = new Label[99];
    @FXML private Label[] timeList = new Label[99];
    
    public void weekSelected(ActionEvent event) throws IOException {
        calendar.getChildren().removeAll(dateList);
        calendar.getChildren().removeAll(titleList);
        calendar.getChildren().removeAll(timeList);
        // Week of Dec 31 - Jan 6
        if (this.weekSelector.getValue().equals("Dec 31 - Jan 6")) {
            dateList[0] = new Label("Dec 31");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            for (int i=1 ; i<7 ; i++) {
                dateList[i] = new Label("Jan " + i);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jan")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jan 7 - Jan 13
        if (this.weekSelector.getValue().equals("Jan 7 - Jan 13")) {
            int m=7;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jan " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jan")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jan 14 - Jan 20
        if (this.weekSelector.getValue().equals("Jan 14 - Jan 20")) {
            int m=14;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jan " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jan")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jan 21 - 27
        if (this.weekSelector.getValue().equals("Jan 21 - Jan 27")) {
            int m=21;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jan " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jan")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jan 28 - Feb 3
        if (this.weekSelector.getValue().equals("Jan 28 - Feb 3")) {
            dateList[0] = new Label("Jan 28");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Jan 29");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Jan 30");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("Jan 31");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            int m=1;
            for (int i=4 ; i<7 ; i++) {
                dateList[i] = new Label("Feb " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jan") || month.equals("Feb")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Feb 4 - Feb 10
        if (this.weekSelector.getValue().equals("Feb 4 - Feb 10")) {
            int m=4;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Feb " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Feb")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Feb 11 - Feb 17
        if (this.weekSelector.getValue().equals("Feb 11 - Feb 17")) {
            int m=11;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Feb " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Feb")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Feb 18 - Feb 24
        if (this.weekSelector.getValue().equals("Feb 18 - Feb 24")) {
            int m=18;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Feb " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Feb")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Feb 25 - Mar 3
        if (this.weekSelector.getValue().equals("Feb 25 - Mar 3")) {
            dateList[0] = new Label("Feb 25");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Feb 26");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Feb 27");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("Feb 28");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            int m=1;
            for (int i=4 ; i<7 ; i++) {
                dateList[i] = new Label("Mar " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Feb") || month.equals("Mar")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Mar 4 - Mar 10
        if (this.weekSelector.getValue().equals("Mar 4 - Mar 10")) {
            int m=4;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Mar " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Mar")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Mar 11 - Mar 17
        if (this.weekSelector.getValue().equals("Mar 11 - Mar 17")) {
            int m=11;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Mar " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Mar")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Mar 18 - Mar 24
        if (this.weekSelector.getValue().equals("Mar 18 - Mar 24")) {
            int m=18;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Mar " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Mar")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Mar 25 - Mar 31
        if (this.weekSelector.getValue().equals("Mar 25 - Mar 31")) {
            int m=25;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Mar " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Mar")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Apr 1 - Apr 7
        if (this.weekSelector.getValue().equals("Apr 1 - Apr 7")) {
            int m=1;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Apr " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Apr")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Apr 8 - 14
        if (this.weekSelector.getValue().equals("Apr 8 - Apr 14")) {
            int m=8;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Apr " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Apr")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Apr 15 - Apr 21
        if (this.weekSelector.getValue().equals("Apr 15 - Apr 21")) {
            int m=15;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Apr " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Apr")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Apr 22 - Apr 28
        if (this.weekSelector.getValue().equals("Apr 22 - Apr 28")) {
            int m=22;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Apr " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Apr")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Apr 29 - May 5
        if (this.weekSelector.getValue().equals("Apr 29 - May 5")) {
            dateList[0] = new Label("Apr 29");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Apr 30");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            int m=1;
            for (int i=2 ; i<7 ; i++) {
                dateList[i] = new Label("May " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Apr") || month.equals("May")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of May 6 - May 12
        if (this.weekSelector.getValue().equals("May 6 - May 12")) {
            int m=6;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("May " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("May")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of May 13 - May 19
        if (this.weekSelector.getValue().equals("May 13 - May 19")) {
            int m=13;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("May " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("May")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of May 20 - May 26
        if (this.weekSelector.getValue().equals("May 20 - May 26")) {
            int m=20;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("May " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("May")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of May 27 - Jun 2
        if (this.weekSelector.getValue().equals("May 27 - Jun 2")) {
            dateList[0] = new Label("May 27");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("May 28");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("May 29");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("May 30");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            dateList[4] = new Label("May 31");
            GridPane.setConstraints(dateList[4],4,1);
            calendar.getChildren().add(dateList[4]);
            GridPane.setValignment(dateList[4], VPos.BOTTOM);
            int m=1;
            for (int i=5 ; i<7 ; i++) {
                dateList[i] = new Label("Jun " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("May") || month.equals("Jun")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jun 3 - Jun 9
        if (this.weekSelector.getValue().equals("Jun 3 - Jun 9")) {
            int m=3;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jun " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jun")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jun 10 - Jun 16
        if (this.weekSelector.getValue().equals("Jun 10 - Jun 16")) {
            int m=10;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jun " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jun")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jun 17 - 23
        if (this.weekSelector.getValue().equals("Jun 17 - Jun 23")) {
            int m=17;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jun " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jun")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jun 24 - Jun 30
        if (this.weekSelector.getValue().equals("Jun 24 - Jun 30")) {
            int m=24;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jun " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jun")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jul 1 - Jul 7
        if (this.weekSelector.getValue().equals("Jul 1 - Jul 7")) {
            int m=1;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jul " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jul")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jul 8 - Jul 14
        if (this.weekSelector.getValue().equals("Jul 8 - Jul 14")) {
            int m=8;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jul " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jul")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jul 15 - Jul 21
        if (this.weekSelector.getValue().equals("Jul 15 - Jul 21")) {
            int m=15;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jul " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jul")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jul 22 - Jul 28
        if (this.weekSelector.getValue().equals("Jul 22 - Jul 28")) {
            int m=22;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Jul " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jul")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Jul 29 - Aug 4
        if (this.weekSelector.getValue().equals("Jul 29 - Aug 4")) {
            dateList[0] = new Label("Jul 29");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Jul 30");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Jul 31");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            int m=1;
            for (int i=3 ; i<7 ; i++) {
                dateList[i] = new Label("Aug " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Jul") || month.equals("Aug")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Aug 5 - Aug 11
        if (this.weekSelector.getValue().equals("Aug 5 - Aug 11")) {
            int m=5;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Aug " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Aug")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Aug 12 - Aug 18
        if (this.weekSelector.getValue().equals("Aug 12 - Aug 18")) {
            int m=12;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Aug " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Aug")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Aug 19 - Aug 25
        if (this.weekSelector.getValue().equals("Aug 19 - Aug 25")) {
            int m=19;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Aug " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Aug")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Aug 26 - Sep 1
        if (this.weekSelector.getValue().equals("Aug 26 - Sep 1")) {
            dateList[0] = new Label("Aug 26");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Aug 27");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Aug 28");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("Aug 29");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            dateList[4] = new Label("Aug 30");
            GridPane.setConstraints(dateList[4],4,1);
            calendar.getChildren().add(dateList[4]);
            GridPane.setValignment(dateList[4], VPos.BOTTOM);
            dateList[5] = new Label("Aug 31");
            GridPane.setConstraints(dateList[5],5,1);
            calendar.getChildren().add(dateList[5]);
            GridPane.setValignment(dateList[5], VPos.BOTTOM);
            int m=1;
            for (int i=6 ; i<7 ; i++) {
                dateList[i] = new Label("Sep " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Aug") || month.equals("Sep")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Sep 2 - Sep 8
        if (this.weekSelector.getValue().equals("Sep 2 - Sep 8")) {
            int m=2;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Sep " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Sep")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Sep 9 - Sep 15
        if (this.weekSelector.getValue().equals("Sep 9 - Sep 15")) {
            int m=9;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Sep " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Sep")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Sep 16 - Sep 22
        if (this.weekSelector.getValue().equals("Sep 16 - Sep 22")) {
            int m=16;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Sep " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Sep")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Sep 23 - Sep 29
        if (this.weekSelector.getValue().equals("Sep 23 - Sep 29")) {
            int m=23;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Sep " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Sep")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Sep 30 - Oct 6
        if (this.weekSelector.getValue().equals("Sep 30 - Oct 6")) {
            dateList[0] = new Label("Sep 30");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            int m=1;
            for (int i=1 ; i<7 ; i++) {
                dateList[i] = new Label("Oct " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Sep") || month.equals("Oct")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Oct 7 - Oct 13
        if (this.weekSelector.getValue().equals("Oct 7 - Oct 13")) {
            int m=7;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Oct " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Oct")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Oct 14 - Oct 20
        if (this.weekSelector.getValue().equals("Oct 14 - Oct 20")) {
            int m=14;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Oct " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Oct")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Oct 21 - Oct 27
        if (this.weekSelector.getValue().equals("Oct 21 - Oct 27")) {
            int m=21;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Oct " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Oct")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Oct 28 - Nov 3
        if (this.weekSelector.getValue().equals("Oct 28 - Nov 3")) {
            dateList[0] = new Label("Oct 28");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Oct 29");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Oct 30");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("Oct 31");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            int m=1;
            for (int i=4 ; i<7 ; i++) {
                dateList[i] = new Label("Nov " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Oct") || month.equals("Nov")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Nov 4 - Nov 10
        if (this.weekSelector.getValue().equals("Nov 4 - Nov 10")) {
            int m=4;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Nov " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Nov")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Nov 11 - Nov 17
        if (this.weekSelector.getValue().equals("Nov 11 - Nov 17")) {
            int m=11;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Nov " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Nov")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Nov 18 - 24
        if (this.weekSelector.getValue().equals("Nov 18 - Nov 24")) {
            int m=18;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Nov " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Nov")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Nov 25 - Dec 1
        if (this.weekSelector.getValue().equals("Nov 25 - Dec 1")) {
            dateList[0] = new Label("Nov 25");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Nov 26");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            dateList[2] = new Label("Nov 27");
            GridPane.setConstraints(dateList[2],2,1);
            calendar.getChildren().add(dateList[2]);
            GridPane.setValignment(dateList[2], VPos.BOTTOM);
            dateList[3] = new Label("Nov 28");
            GridPane.setConstraints(dateList[3],3,1);
            calendar.getChildren().add(dateList[3]);
            GridPane.setValignment(dateList[3], VPos.BOTTOM);
            dateList[4] = new Label("Nov 29");
            GridPane.setConstraints(dateList[4],4,1);
            calendar.getChildren().add(dateList[4]);
            GridPane.setValignment(dateList[4], VPos.BOTTOM);
            dateList[5] = new Label("Nov 30");
            GridPane.setConstraints(dateList[5],5,1);
            calendar.getChildren().add(dateList[5]);
            GridPane.setValignment(dateList[5], VPos.BOTTOM);
            int m=1;
            for (int i=6 ; i<7 ; i++) {
                dateList[i] = new Label("Dec " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Nov") || month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Dec 2 - Dec 8
        if (this.weekSelector.getValue().equals("Dec 2 - Dec 8")) {
            int m=2;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Dec " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Dec 9 - Dec 15
        if (this.weekSelector.getValue().equals("Dec 9 - Dec 15")) {
            int m=9;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Dec " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Dec 16 - Dec 22
        if (this.weekSelector.getValue().equals("Dec 16 - Dec 22")) {
            int m=16;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Dec " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Dec 23 - Dec 29
        if (this.weekSelector.getValue().equals("Dec 23 - Dec 29")) {
            int m=23;
            for (int i=0 ; i<7 ; i++) {
                dateList[i] = new Label("Dec " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
                        }
                    }
                }
            }
        }
        // Week of Dec 30 - Jan 5
        if (this.weekSelector.getValue().equals("Dec 30 - Jan 5")) {
            dateList[0] = new Label("Dec 30");
            GridPane.setConstraints(dateList[0],0,1);
            calendar.getChildren().add(dateList[0]);
            GridPane.setValignment(dateList[0], VPos.BOTTOM);
            dateList[1] = new Label("Dec 31");
            GridPane.setConstraints(dateList[1],1,1);
            calendar.getChildren().add(dateList[1]);
            GridPane.setValignment(dateList[1], VPos.BOTTOM);
            int m=1;
            for (int i=2 ; i<7 ; i++) {
                dateList[i] = new Label("Jan " + m);
                GridPane.setConstraints(dateList[i],i,1);
                calendar.getChildren().add(dateList[i]);
                GridPane.setValignment(dateList[i], VPos.BOTTOM);
                m++;
                }  int limit = AppointmentsController.appointments.size();
                   String month;
                   String monthDay;
                   for (int j=0 ; j<limit ; j++) { 
                       month = new SimpleDateFormat("MMM").format(AppointmentsController.appointments.get(j).getStart());
                       if (month.equals("Dec")) {
                           monthDay = new SimpleDateFormat("MMM d").format(AppointmentsController.appointments.get(j).getStart());
                           int columnIndex;
                           int rowIndex;
                            for (int k=0 ; k<7 ; k++) {
                           if (monthDay.equals(dateList[k].getText())) {
                            String time = new SimpleDateFormat("H:mm a").format(AppointmentsController.appointments.get(j).getStart());
                            titleList[j] = new Label(AppointmentsController.appointments.get(j).getTitle());
                            timeList[j] = new Label(time);
                            calendar.getChildren().add(titleList[j]);
                            calendar.getChildren().add(timeList[j]);
                            GridPane.setValignment(titleList[j], VPos.TOP);
                            columnIndex = GridPane.getColumnIndex(dateList[k]);
                            rowIndex = GridPane.getRowIndex(dateList[k]);
                            GridPane.setConstraints(titleList[j],columnIndex,rowIndex);
                            GridPane.setConstraints(timeList[j],columnIndex,rowIndex);
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

    public void viewByMonth(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("calendarMonth.fxml"));
        Parent calMonParent = loader.load();
        Scene calMonScene = new Scene(calMonParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(calMonScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        weekSelector.getItems().addAll("Dec 31 - Jan 6","Jan 7 - Jan 13","Jan 14 - Jan 20","Jan 21 - Jan 27",
                "Jan 28 - Feb 3","Feb 4 - Feb 10","Feb 11 - Feb 17","Feb 18 - Feb 24",
                "Feb 25 - Mar 3","Mar 4 - Mar 10","Mar 11 - Mar 17","Mar 18 - Mar 24", "Mar 25 - Mar 31",
                "Apr 1 - Apr 7","Apr 8 - Apr 14","Apr 15 - Apr 21","Apr 22 - Apr 28",
                "Apr 29 - May 5","May 6 - May 12","May 13 - May 19", "May 20 - May 26",
                "May 27 - Jun 2","Jun 3 - Jun 9","Jun 10 - Jun 16","Jun 17 - Jun 23","Jun 24 - Jun 30",
                "Jul 1 - Jul 7","Jul 8 - Jul 14","Jul 15 - Jul 21","Jul 22 - Jul 28",
                "Jul 29 - Aug 4","Aug 5 - Aug 11","Aug 12 - Aug 18","Aug 19 - Aug 25",
                "Aug 26 - Sep 1","Sep 2 - Sep 8","Sep 9 - Sep 15","Sep 16 - Sep 22", "Sep 23 - Sep 29",
                "Sep 30 - Oct 6","Oct 7 - Oct 13","Oct 14 - Oct 20","Oct 21 - Oct 27",
                "Oct 28 - Nov 3","Nov 4 - Nov 10","Nov 11 - Nov 17","Nov 18 - Nov 24",
                "Nov 25 - Dec 1","Dec 2 - Dec 8","Dec 9 - Dec 15","Dec 16 - Dec 22","Dec 23 - Dec 29",
                "Dec 30 - Jan 5");
    }      
}
