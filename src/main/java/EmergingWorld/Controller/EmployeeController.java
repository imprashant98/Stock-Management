/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Emp_Table;
import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class EmployeeController implements Initializable {

public Button backButton;

Connection con;
    
    @FXML
    public TableColumn<Emp_Table,String> EmpNameCol;

    @FXML
    public TableView<Emp_Table> EmpTable;
    
    @FXML
    public Button Refreshbutton;

    @FXML
    public AnchorPane EmpMAinPane;

    @FXML
    public TableColumn<Emp_Table,String > EmpAddrCol;

    @FXML
    public Button RemoveEmpButton;

    @FXML
    public Pane EmpPaneBottom;

    @FXML
    public TableColumn<Emp_Table, String> EmpIdCol;

    @FXML
    public Pane EmpPaneTop;
    
    @FXML
    public TableColumn<Emp_Table, String> CitizenshipCol;

    @FXML
    public Button AddEmpButton;

    @FXML
    public TableColumn<Emp_Table, String> EmpGenderCol;
    
    @FXML
    public TableColumn<Emp_Table, String> EmpContact;
@FXML
public TableColumn<Emp_Table,String> DesignationCol;
@FXML
public TableColumn<Emp_Table,String> EmailCol;
    
    @FXML
    void RefreshAction(ActionEvent event) {
        fill();
    }
    
    @FXML
    public void AddEmpAction(ActionEvent event) {

        StageManager.getInstance().addEmployeeStage.show();
        StageManager.getInstance().employeeStage.hide();
    }

    @FXML
    void RemEmpAction(ActionEvent event) {
        int Index = EmpTable.getSelectionModel().getSelectedIndex();
        Emp_Table selected = EmpTable.getSelectionModel().getSelectedItem();
        String  p = selected.getEid();
        if(Index<0){
          //  JOptionPane.showMessageDialog(null, "No Employee Selected");
            new Alert(Alert.AlertType.WARNING, "No Employee Selected", ButtonType.OK).showAndWait();
        }
        else{
            try{
            int c=0; 
            String str1;
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="Delete from Employee where Emp_ID = '"+p+"'";
             PreparedStatement stmt=con.prepareStatement(str);
             stmt.executeUpdate(str);
             stmt.close();
             EmpTable.getItems().remove(selected);
        }
        catch(Exception e){
          //  JOptionPane.showMessageDialog(null, e.getMessage());
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
            
        
        }
        }
    }
    void fill(){
        ObservableList<Emp_Table> data=FXCollections.observableArrayList();
        
        
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        EmpNameCol.setCellValueFactory(new PropertyValueFactory<>("Ename"));
        EmpGenderCol.setCellValueFactory(new PropertyValueFactory<>("Egender"));
        EmpAddrCol.setCellValueFactory(new PropertyValueFactory<>("Eaddr"));
        EmpContact.setCellValueFactory(new PropertyValueFactory<>("Econtact"));
        CitizenshipCol.setCellValueFactory(new PropertyValueFactory<>("Ecitizenship"));
        DesignationCol.setCellValueFactory(new PropertyValueFactory<>("Edesignation"));
        EmailCol.setCellValueFactory(new PropertyValueFactory<>("Eemail"));
        
        EmpTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Employee";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                data.add(new Emp_Table(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        String.valueOf(rs.getLong(5)),
                        String.valueOf(rs.getLong(6)),
                        rs.getString(7),
                 rs.getString(8)));
                
             }
             EmpTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        fill();
    }

public void onBack(ActionEvent event) {
        StageManager.getInstance().adminStage.show();
        StageManager.getInstance().employeeStage.hide();
}
public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}
}
