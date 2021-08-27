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
import java.time.LocalDate;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Bills_table;
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
public class BillsController implements Initializable {



Connection con;
    
    @FXML
    public TableView<Bills_table> BillsTable;

    @FXML
    public TableColumn<Bills_table, String> BillsContactCol;

    @FXML
    public TableColumn<Bills_table, String> BillsProductNameCol;

    @FXML
    public TableColumn<Bills_table, String> BillsCustomerAddrCol;

    @FXML
    public Pane BillsTopPane;
    
    @FXML
    public Button RefreshButton;

    @FXML

    public TextField ProductIdTextField;
    
    @FXML
    public DatePicker BillsDate;

    @FXML
    public TableColumn<Bills_table, String> BillsProductIdCol;
    
    @FXML
    public TableColumn<Bills_table, String> EmpIdCol;

    @FXML
    public Button DateButton;

    @FXML
    public Button ProductIdButton;
    @FXML
    public Button backButton;

    @FXML
    public Pane BillsBottomPane;
    
//    @FXML
//    public TableView Bills_Table;


    
    @FXML
    public AnchorPane BillsMainPane;

    @FXML
    public TableColumn<Bills_table, String> BillsDateCol;

    @FXML
    public TableColumn<Bills_table, String> BillsCustomerNameCol;
    
    @FXML
   public  void RefreshAction(ActionEvent event) {
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
       
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
   
             while(rs.next()){
                 String k = rs.getString(10);
                 String s=rs.getString(2);
                 String p=rs.getString(3);
                 s=s+"-"+p;
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),s,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }
    
    @FXML
   public void SearchByIdAction(ActionEvent event) {
        String d = String.valueOf(ProductIdTextField.getText());
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
        
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                if(String.valueOf(rs.getString(1)).equals(d)){
                    String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
                }
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }

    }
    
    @FXML
    public void SearchByDateAction(ActionEvent event) {
        LocalDate l = BillsDate.getValue();
        String d = String.valueOf(l);
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
      
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                if(String.valueOf(rs.getString(8)).equals(d)){
                    String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             
                }
             }
             
             BillsTable.setItems(data);
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
        ObservableList<Bills_table> data=FXCollections.observableArrayList();
        
        
        BillsProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Pid"));
        BillsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        BillsCustomerNameCol.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        BillsCustomerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Caddr"));
        BillsContactCol.setCellValueFactory(new PropertyValueFactory<>("Ccontact"));
        BillsDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        EmpIdCol.setCellValueFactory(new PropertyValueFactory<>("Eid"));
       
        BillsTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from sold_item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 String k = rs.getString(10);
                 if(k==null)
                     k = "N.A.";
                data.add(new Bills_table(rs.getString(1),rs.getString(2)+"-"+rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),k));  
             }
             
             BillsTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}

public void onBack(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().billStage.hide();
}
}
